package com.app.GroupMatching.services.Interfaces;

import com.app.GroupMatching.entities.Group;
import com.app.GroupMatching.entities.User;

import java.util.Set;

public interface MultipleMatchServiceI {
    public void addMatchesForNewUser(User newUser, Set<Group> groups);
    public void addMatchesForNewGroup(Group newGroup, Set<User> users);
}
