package com.app.GroupMatching.repositories;

import com.app.GroupMatching.entities.Match;
import com.app.GroupMatching.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    Set<Match> findAllByUserOrderByMatchPercentageDesc(User user);
}
