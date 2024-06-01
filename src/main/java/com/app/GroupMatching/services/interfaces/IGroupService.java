package com.app.GroupMatching.services.interfaces;

import com.app.GroupMatching.dto.requests.GroupCreateRequest;
import com.app.GroupMatching.entities.Group;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface IGroupService {
    public List<Group> getAllGroups();

    ResponseEntity<?> createGroup(GroupCreateRequest groupCreateRequest);

    public Group getGroupById(Long groupId);

    public Set<Group> getGroupsBasedOnUserAndSortedByMatchPercentage(
            Long userId
    );
}
