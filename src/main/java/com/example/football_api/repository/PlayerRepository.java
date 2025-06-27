package com.example.football_api.repository;

import com.example.football_api.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Page<Player> findAll(Pageable pageable);
    List<Player> findByTeamId(Long teamId);
}
