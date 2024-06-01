package com.app.GroupMatching.controllers;

import com.app.GroupMatching.entities.Language;
import com.app.GroupMatching.entities.Skill;
import com.app.GroupMatching.services.Interfaces.LanguageServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/language")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageServiceI languageService;

    @GetMapping("/all")
    @ResponseBody
    List<Language> findAll(){
        return languageService.findAllLanguages();
    }
}
