package com.example.football_api.repository;

import com.example.football_api.model.Match;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    Page<Match> findAll(Pageable pageable);
    List<Match> findByHomeTeamIdOrAwayTeamId(Long homeId, Long awayId);
}
