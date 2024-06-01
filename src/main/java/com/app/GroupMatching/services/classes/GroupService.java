package com.app.GroupMatching.services.classes;

import com.app.GroupMatching.entities.Group;
import com.app.GroupMatching.repositories.GroupRepository;
import com.app.GroupMatching.services.interfaces.IGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService implements IGroupService {
    private final GroupRepository groupRepository;

    @Override
    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }
}
