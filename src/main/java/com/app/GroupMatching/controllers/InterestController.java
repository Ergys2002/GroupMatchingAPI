package com.app.GroupMatching.controllers;


import com.app.GroupMatching.entities.Interest;
import com.app.GroupMatching.entities.Language;
import com.app.GroupMatching.entities.Skill;
import com.app.GroupMatching.services.Impl.InterestService;
import com.app.GroupMatching.services.Interfaces.LanguageServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

