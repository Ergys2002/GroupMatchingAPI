package com.app.GroupMatching.services.classes;


import com.app.GroupMatching.config.JwtService;
import com.app.GroupMatching.dto.requests.AuthenticationRequest;
import com.app.GroupMatching.dto.requests.PreferencesRequest;
import com.app.GroupMatching.dto.requests.RegisterRequest;
import com.app.GroupMatching.dto.responses.AuthenticationResponse;
import com.app.GroupMatching.entities.*;
import com.app.GroupMatching.repositories.UserRepository;
import com.app.GroupMatching.services.MultipleMatchService;
import com.app.GroupMatching.services.interfaces.IGroupService;
import com.app.GroupMatching.services.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final MultipleMatchService multipleMatchService;
    private final IGroupService groupService;
    private final InterestService interestService;
    private final LanguageService languageService;
    private final SkillService skillService;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public ResponseEntity<AuthenticationResponse> register(RegisterRequest request) {

        User fromDb = userRepository.findByEmail(request.getEmail());

        System.out.println(fromDb);
        if (fromDb == null) {

            var user = User.builder()
                    .name(request.getName())
                    .lastname(request.getLastname())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .birthDate(request.getBirthDate())
                    .phoneNumber(request.getPhoneNumber())
                    .likes(0)
                    .position(request.getPosition())
                    .build();

            User savedUser = userRepository.save(user);

            List<Group> groups = groupService.getAllGroups();
            if (groups != null){
                multipleMatchService.addMatchesForNewUser(savedUser, new HashSet<>(groups));
            }
            String jwtToken = jwtService.generateToken(user);
            return new ResponseEntity<>(AuthenticationResponse.builder()
                    .token(jwtToken)
                    .message("Registered Succesfully")
                    .validUntil(
                            jwtService.extractAllClaims(jwtToken)
                                    .getExpiration()
                                    .toInstant()
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDate())
                    .build(), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail());

        String jwtToken = jwtService.generateToken(user);

        LocalDate localDate = jwtService.extractAllClaims(jwtToken)
                .getExpiration()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        System.out.println(localDate);

        return new ResponseEntity<>(AuthenticationResponse.builder()
                .token(jwtToken)
                .message("Logged in Succesfully")
                .validUntil(
                        jwtService.extractAllClaims(jwtToken)
                                .getExpiration()
                                .toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate())
                .build(), HttpStatus.ACCEPTED);
    }
    @Override
    public ResponseEntity<?> getUsersMatchingWithAGroupByGroupId(Long groupId){
            Group groupById = groupService.getGroupById(groupId);
            Set<User> users = new HashSet<>();
            groupById.getMatches().stream().forEach(
                    match -> users.add(match.getUser())
            );
            return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @Override
    public User getUserById(Long id){
       return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUserPreferences(Long userId, PreferencesRequest preferencesRequest){

        User user = userRepository.findById(userId).get();

        Set<UserLanguage> languages  = languageService
                .findLanguageBasedOnId(preferencesRequest.getLanguagesId())
               .stream().map(language -> new UserLanguage(user,language))
                .collect(Collectors.toSet());

        Set<UserInterest> interests  = interestService
                .findInterestBasedOnId(preferencesRequest.getInterestId())
                .stream().map(interest -> new UserInterest(user,interest))
                .collect(Collectors.toSet());

        Set<UserSkill> skills  = skillService
                .findSkillsBasedOnId(preferencesRequest.getSkillsId())
                .stream().map(skill -> new UserSkill(user,skill))
                .collect(Collectors.toSet());

        user.setLanguages(languages);
        user.setInterests(interests);
        user.setSkills(skills);

        return userRepository.save(user);
    }

}
