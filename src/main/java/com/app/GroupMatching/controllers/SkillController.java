package com.app.GroupMatching.controllers;

import com.app.GroupMatching.entities.Skill;
import com.app.GroupMatching.services.Interfaces.SkillServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
@RequiredArgsConstructor
public class SkillController {

    private final SkillServiceI skillService;

    @GetMapping("/all")
    @ResponseBody List<Skill> findAll(){
        return skillService.findAllSkills();
    }
}
