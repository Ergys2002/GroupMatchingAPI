package com.app.GroupMatching.services.classes;

import com.app.GroupMatching.dto.requests.GroupCreateRequest;
import com.app.GroupMatching.entities.Group;
import com.app.GroupMatching.entities.GroupSkill;
import com.app.GroupMatching.entities.User;
import com.app.GroupMatching.enums.GroupStatus;
import com.app.GroupMatching.repositories.GroupRepository;
import com.app.GroupMatching.services.interfaces.IGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GroupService implements IGroupService {
    private final GroupRepository groupRepository;
    private final UserService userService;

    @Override
    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }

    @Override
    public ResponseEntity<?> createGroup(GroupCreateRequest groupCreateRequest) {

        User leader = userService.getUserById(groupCreateRequest.getLeaderId());
        Group groupToBeSaved = Group.builder().title(groupCreateRequest.getTitle())
                .leader(leader).capacity(groupCreateRequest.getCapacity()).status(GroupStatus.ACTIVE)
                .build();

        //vendosi skillsat dhe languages grupit

        return null;
    }
}
