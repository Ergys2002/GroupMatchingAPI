package com.app.GroupMatching.services;

import com.app.GroupMatching.repositories.MatchRepository;
import com.app.GroupMatching.entities.Group;
import com.app.GroupMatching.entities.Match;
import com.app.GroupMatching.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class MultipleMatchService {

    private static final Logger logger = LoggerFactory.getLogger(MultipleMatchService.class);

    private final MatchService matchService;
    private final MatchRepository matchRepository;

    @Transactional
    public void addMatchesForNewUser(User newUser, List<Group> groups){
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
    public void addMatchesForNewGroup(Group newGroup, List<User> users){
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
