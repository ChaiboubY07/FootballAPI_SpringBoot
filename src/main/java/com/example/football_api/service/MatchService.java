package com.example.football_api.service;

import com.example.football_api.model.Match;
import com.example.football_api.repository.MatchRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository repo;

    public MatchService(MatchRepository repo) {
        this.repo = repo;
    }

    public List<Match> getAll() {
        return repo.findAll();
    }

    public Page<Match> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }


    public Match getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Match introuvable"));
    }

    public List<Match> getByTeamId(Long teamId) {
        return repo.findByHomeTeamIdOrAwayTeamId(teamId, teamId);
    }

    public Match create(Match match) {
        return repo.save(match);
    }

    public Match update(Long id, Match updated) {
        return repo.findById(id).map(m -> {
            m.setMatchDate(updated.getMatchDate());
            m.setHomeScore(updated.getHomeScore());
            m.setAwayScore(updated.getAwayScore());
            m.setHomeTeam(updated.getHomeTeam());
            m.setAwayTeam(updated.getAwayTeam());
            m.setStadium(updated.getStadium());
            return repo.save(m);
        }).orElseThrow(() -> new RuntimeException("Match introuvable"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
