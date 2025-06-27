package com.example.football_api.service;

import com.example.football_api.model.Player;
import com.example.football_api.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository repo;

    public PlayerService(PlayerRepository repo) {
        this.repo = repo;
    }

    public Page<Player> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Player getPlayerById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Joueur introuvable"));
    }

    public List<Player> getPlayersByTeam(Long teamId) {
        return repo.findByTeamId(teamId);
    }

    public Player createPlayer(Player player) {
        return repo.save(player);
    }

    public Player updatePlayer(Long id, Player updated) {
        return repo.findById(id).map(p -> {
            p.setName(updated.getName());
            p.setAge(updated.getAge());
            p.setPosition(updated.getPosition());
            p.setTeam(updated.getTeam());
            return repo.save(p);
        }).orElseThrow(() -> new RuntimeException("Joueur introuvable"));
    }

    public void deletePlayer(Long id) {
        repo.deleteById(id);
    }
}
