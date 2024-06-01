package com.app.GroupMatching.services.classes;

import com.app.GroupMatching.entities.Interest;
import com.app.GroupMatching.entities.Language;
import com.app.GroupMatching.repositories.LanguageRepository;
import com.app.GroupMatching.services.Interfaces.LanguageServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LanguageService implements LanguageServiceI {

    private final LanguageRepository languageRepository;

    public List<Language> findLanguageBasedOnId(List<Long> languageId){
        return languageRepository.findAll()
                .stream()
                .filter(language -> languageId.contains(language.getId()))
                .collect(Collectors.toList());
    }

    public List<Language> findAllLanguages(){
        return languageRepository.findAll();
    }
}
