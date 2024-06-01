package com.app.GroupMatching.repositories;

import com.app.GroupMatching.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {
    @Override
    List<Skill> findAll();
}
