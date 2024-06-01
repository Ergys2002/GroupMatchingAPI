package com.app.GroupMatching.services.classes;

import com.app.GroupMatching.dto.requests.GroupCreateRequest;
import com.app.GroupMatching.dto.responses.GroupResponse;
import com.app.GroupMatching.entities.*;
import com.app.GroupMatching.enums.GroupStatus;
import com.app.GroupMatching.repositories.GroupRepository;
import com.app.GroupMatching.repositories.MatchRepository;
import com.app.GroupMatching.repositories.UserRepository;
import com.app.GroupMatching.services.MultipleMatchService;
import com.app.GroupMatching.services.interfaces.IGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupService implements IGroupService {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final LanguageService languageService;
    private final SkillService skillService;
    private final MultipleMatchService multipleMatchService;
    private final MatchRepository matchRepository;

    @Override
    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }

    public Group getGroupById(Long groupId){
        return groupRepository.getReferenceById(groupId);
    }

    public Set<GroupResponse> getGroupsBasedOnUserAndSortedByMatchPercentage(
            Long userId
    ){
      Set<Match> matches = matchRepository
              .findAllByUserOrderByMatchPercentageDesc(
                      userRepository.findById(userId).orElse(null));

        Set<Group> groups = matches.stream().map(Match::getGroup).collect(Collectors.toSet());

        Set<GroupResponse> groupResponses = groups.stream().map(group -> GroupResponse.builder()
                .title(group.getTitle())
                .leader(group.getLeader())
                .capacity(group.getCapacity())
                .description(group.getDescription())
                .logoURL(group.getLogoURL())
                .groupMembers(group.getGroupMembers())
                .groupLanguages(group.getGroupLanguages())
                .groupSkills(group.getGroupSkills())
                .build()
        ).collect(Collectors.toSet());

        return groupResponses;
    }



    @Override
    public ResponseEntity<?> createGroup(GroupCreateRequest groupCreateRequest) {

        User leader = userRepository.findById(groupCreateRequest.getLeaderId()).get();

        Group groupToBeSaved = Group.builder().title(groupCreateRequest.getTitle())
                .leader(leader).capacity(groupCreateRequest.getCapacity()).status(GroupStatus.ACTIVE)
                .build();

        groupRepository.save(groupToBeSaved);
        //vendosi skillsat dhe languages grupit

           List<Skill> skills = skillService
                   .findSkillsBasedOnId(groupCreateRequest.getGroupSkillsIds());
           List<Language> languages = languageService
                   .findLanguageBasedOnId(groupCreateRequest.getGroupLanguagesIds());

           Set<GroupSkill> groupSkills = skills.stream()
                   .map(skill -> new GroupSkill(groupToBeSaved,skill))
                   .collect(Collectors.toSet());

           Set<GroupLanguage> groupLanguages= languages.stream()
                    .map(language -> new GroupLanguage(language,groupToBeSaved))
                    .collect(Collectors.toSet());

       groupToBeSaved.setGroupSkills(groupSkills);
       groupToBeSaved.setGroupLanguages(groupLanguages);

       //Shto matches per grupin
        multipleMatchService.addMatchesForNewGroup(groupToBeSaved,
                new HashSet<>(userRepository.findAll()));


     try {
         return new ResponseEntity<>(groupRepository.save(groupToBeSaved),
                 HttpStatus.OK);
     }catch (IllegalArgumentException e){
         return new ResponseEntity<>(groupRepository.save(groupToBeSaved),
                 HttpStatus.CONFLICT);
     }
    }
}
