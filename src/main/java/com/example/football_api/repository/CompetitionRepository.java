package com.example.football_api.repository;

import com.example.football_api.model.Competition;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    Page<Competition> findAll(Pageable pageable);
}
