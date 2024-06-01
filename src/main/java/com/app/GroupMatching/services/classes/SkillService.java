package com.app.GroupMatching.services.classes;

import com.app.GroupMatching.entities.Skill;
import com.app.GroupMatching.repositories.SkillRepository;
import com.app.GroupMatching.services.Interfaces.SkillServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillService implements SkillServiceI {

    private final SkillRepository skillRepository;
    public List<Skill> findAllSkills(){
        return skillRepository.findAll();
    }

    public List<Skill> findSkillsBasedOnId(List<Long> skillId){
        return skillRepository.findAll()
                .stream()
                .filter(skill -> skillId.contains(skill.getId()))
                .collect(Collectors.toList());
    }
}
