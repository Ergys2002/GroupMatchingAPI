package com.app.GroupMatching.services.classes;


import com.app.GroupMatching.config.JwtService;
import com.app.GroupMatching.dto.requests.AuthenticationRequest;
import com.app.GroupMatching.dto.requests.RegisterRequest;
import com.app.GroupMatching.dto.responses.AuthenticationResponse;
import com.app.GroupMatching.entities.Group;
import com.app.GroupMatching.entities.User;
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

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final MultipleMatchService multipleMatchService;
    private final IGroupService groupService;

    @Override
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
                multipleMatchService.addMatchesForNewUser(savedUser, groups);
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

}
