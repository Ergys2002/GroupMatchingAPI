package com.app.GroupMatching.services.Impl;

import com.app.GroupMatching.entities.*;
import com.app.GroupMatching.services.Interfaces.MatchServiceI;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MatchService implements MatchServiceI {
    public double calculateMatchPercentage(User user, Group group) {
        double skillMatch = calculateSkillMatch(user.getSkills(), group.getGroupSkills());
        double languageMatch = calculateLanguageMatch(user.getLanguages(), group.getGroupLanguages());
        double interestMatch = calculateInterestMatch(user.getInterests(), group.getLeader().getInterests());

        return (skillMatch * 5 + languageMatch * 3 + interestMatch * 2) / 10;
    }

    private double calculateSkillMatch(Set<UserSkill> userSkills, Set<GroupSkill> groupSkills) {
        if (userSkills.isEmpty() || groupSkills.isEmpty()) return 0;

        Set<String> userSkillSet = userSkills.stream().map(userSkill -> userSkill.getSkill().getTitle()).collect(Collectors.toSet());
        Set<String> groupSkillSet = groupSkills.stream().map(groupSkill -> groupSkill.getSkill().getTitle()).collect(Collectors.toSet());

        int matches = 0;
        for (String skill : userSkillSet) {
            if (groupSkillSet.contains(skill)) {
                matches++;
            }
        }

        return (double) matches / userSkillSet.size() * 100;
    }

    private double calculateLanguageMatch(Set<UserLanguage> userLanguages, Set<GroupLanguage> groupLanguages) {
        if (userLanguages.isEmpty() || groupLanguages.isEmpty()) return 0;

        Set<String> userLanguageSet = userLanguages.stream().map(userLanguage -> userLanguage.getLanguage().getTitle()).collect(Collectors.toSet());
        Set<String> groupLanguageSet = groupLanguages.stream().map(groupLanguage -> groupLanguage.getLanguage().getTitle()).collect(Collectors.toSet());

        int matches = 0;
        for (String language : userLanguageSet) {
            if (groupLanguageSet.contains(language)) {
                matches++;
            }
        }

        return (double) matches / userLanguageSet.size() * 100;
    }

    private double calculateInterestMatch(Set<UserInterest> userInterests, Set<UserInterest> leaderInterests) {
        if (userInterests.isEmpty() || leaderInterests.isEmpty()) return 0;

        Set<String> userInterestSet = userInterests.stream().map(userInterest -> userInterest.getInterest().getTitle()).collect(Collectors.toSet());
        Set<String> groupInterestSet = leaderInterests.stream().map(leaderInterest -> leaderInterest.getInterest().getTitle()).collect(Collectors.toSet());

        int matches = 0;
        for (String interest : userInterestSet) {
            if (groupInterestSet.contains(interest)) {
                matches++;
            }
        }

        return (double) matches / userInterestSet.size() * 100;
    }
}
