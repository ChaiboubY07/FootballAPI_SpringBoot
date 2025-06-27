package com.example.football_api.service;

import com.example.football_api.model.Team;
import com.example.football_api.repository.TeamRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Page<Team> getAll(Pageable pageable) {
        return teamRepository.findAll(pageable);
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, Team updatedTeam) {
        return teamRepository.findById(id)
            .map(team -> {
                team.setName(updatedTeam.getName());
                team.setCountry(updatedTeam.getCountry());
                team.setFoundedYear(updatedTeam.getFoundedYear());
                return teamRepository.save(team);
            })
            .orElseThrow(() -> new RuntimeException("Team not found"));
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
