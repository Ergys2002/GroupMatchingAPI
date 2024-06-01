package com.app.GroupMatching.controller;


import com.app.GroupMatching.entities.Interest;
import com.app.GroupMatching.services.classes.InterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interest")
@RequiredArgsConstructor
public class InterestController {

    private final InterestService interestService;

    @GetMapping("/all")
    @ResponseBody
    List<Interest> findAll(){
        return interestService.findAllInterests();
    }

}

