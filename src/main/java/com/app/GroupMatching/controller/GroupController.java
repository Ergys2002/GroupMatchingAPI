package com.app.GroupMatching.controller;

import com.app.GroupMatching.dto.requests.GroupCreateRequest;
import com.app.GroupMatching.services.classes.GroupService;
import com.app.GroupMatching.services.interfaces.IGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/group")
@RequiredArgsConstructor
public class GroupController {

    private final IGroupService groupService;

    @PostMapping("/create-group")
    public ResponseEntity<?> createGroup(@RequestBody GroupCreateRequest groupCreateRequest){
        return groupService.createGroup(groupCreateRequest);
    }
}
