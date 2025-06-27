package com.example.football_api.repository;

import com.example.football_api.model.Stadium;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {
    Page<Stadium> findAll(Pageable pageable);
}
