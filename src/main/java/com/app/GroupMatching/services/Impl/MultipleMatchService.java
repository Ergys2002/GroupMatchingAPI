package com.app.GroupMatching.services.Impl;

import com.app.GroupMatching.entities.Group;
import com.app.GroupMatching.entities.Match;
import com.app.GroupMatching.entities.User;
import com.app.GroupMatching.repositories.MatchRepository;
import com.app.GroupMatching.services.Interfaces.MultipleMatchServiceI;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@AllArgsConstructor
public class MultipleMatchService implements MultipleMatchServiceI {

    private static final Logger logger = LoggerFactory.getLogger(MultipleMatchService.class);

    private final MatchService matchService;
    private final MatchRepository matchRepository;

    @Transactional
    public void addMatchesForNewUser(User newUser, Set<Group> groups){
        try {
            for (Group group : groups) {
                double matchPercentage = matchService.calculateMatchPercentage(newUser, group);
                matchRepository.save(Match.builder()
                        .user(newUser)
                        .group(group)
                        .matchPercentage(matchPercentage)
                        .build());
                logger.info("Match saved for User: {} and Group: {} with Match Percentage: {}", newUser.getId(), group.getId(), matchPercentage);
            }
        } catch (Exception e) {
            logger.error("Error while adding matches for new user: {}", newUser.getId(), e);
            throw e;
        }
    }

    @Transactional
    public void addMatchesForNewGroup(Group newGroup, Set<User> users){
        try {
            for (User user : users) {
                double matchPercentage = matchService.calculateMatchPercentage(user, newGroup);
                matchRepository.save(Match.builder()
                        .user(user)
                        .group(newGroup)
                        .matchPercentage(matchPercentage)
                        .build());
                logger.info("Match saved for User: {} and Group: {} with Match Percentage: {}", user.getId(), newGroup.getId(), matchPercentage);
            }
        } catch (Exception e) {
            logger.error("Error while adding matches for new group: {}", newGroup.getId(), e);
            throw e;
        }
    }
}
