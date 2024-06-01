package com.app.GroupMatching.controller;

import com.app.GroupMatching.dto.requests.GroupMemberRequest;
import com.app.GroupMatching.entities.GroupMember;
import com.app.GroupMatching.services.classes.GroupMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class GroupMemberController {

    private final GroupMemberService groupMemberService;

    @PostMapping("/user-join-group")
    public ResponseEntity<?> userJoinGroup(@RequestBody GroupMemberRequest request){
       GroupMember groupMember = groupMemberService.userJoinGroup(request
                .getUserId(), request.getGroupId());

       return new ResponseEntity<>(groupMember, HttpStatus.OK);
    }

}
