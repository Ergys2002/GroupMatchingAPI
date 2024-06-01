package com.app.GroupMatching.services.Interfaces;

import com.app.GroupMatching.entities.Group;
import com.app.GroupMatching.entities.GroupSkill;
import com.app.GroupMatching.entities.User;
import com.app.GroupMatching.entities.UserSkill;

import java.util.Set;

public interface MatchServiceI {
    double calculateMatchPercentage(User user, Group group);
}
