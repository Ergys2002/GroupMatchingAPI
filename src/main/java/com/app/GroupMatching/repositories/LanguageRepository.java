package com.app.GroupMatching.repositories;

import com.app.GroupMatching.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Long> {
    @Override
    List<Language> findAll();
}
