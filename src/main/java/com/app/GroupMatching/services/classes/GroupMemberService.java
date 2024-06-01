package com.app.GroupMatching.services.classes;

import com.app.GroupMatching.entities.GroupMember;
import com.app.GroupMatching.repositories.GroupMemberRepository;
import com.app.GroupMatching.repositories.GroupRepository;
import com.app.GroupMatching.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupMemberService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final GroupMemberRepository groupMemberRepository;

    public GroupMember userJoinGroup(Long userId,Long groupId){

        GroupMember groupMemberToBeSaved =
                GroupMember.builder()
                        .member(userRepository.getReferenceById(userId))
                        .group(groupRepository.getReferenceById(groupId))
                        .build();

       return groupMemberRepository.save(groupMemberToBeSaved);
    }
}
