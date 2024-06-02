package com.app.GroupMatching.controller;

import com.app.GroupMatching.dto.requests.GroupCreateRequest;
import com.app.GroupMatching.dto.responses.GroupResponse;
import com.app.GroupMatching.services.classes.GroupService;
import com.app.GroupMatching.services.interfaces.IGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/group")
@RequiredArgsConstructor
public class GroupController {

    private final IGroupService groupService;

    @GetMapping("/based-on-user")
    public @ResponseBody ResponseEntity<Set<GroupResponse>> getGroupsBasedOnUserAndSortedByMatchPercentage(
           @RequestParam Long userId
    ){
        return new ResponseEntity<>(
        groupService.getGroupsBasedOnUserAndSortedByMatchPercentage(userId),
                HttpStatus.OK);
    }

    @PostMapping("/create-group")
    public ResponseEntity<?> createGroup(@RequestBody GroupCreateRequest groupCreateRequest){
        return groupService.createGroup(groupCreateRequest);
    }


}
