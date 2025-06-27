package com.example.football_api.service;

import com.example.football_api.model.Competition;
import com.example.football_api.repository.CompetitionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {

    private final CompetitionRepository repo;

    public CompetitionService(CompetitionRepository repo) {
        this.repo = repo;
    }

    public List<Competition> getAll() {
        return repo.findAll();
    }

    public Page<Competition> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }


    public Competition getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Compétition introuvable"));
    }

    public Competition create(Competition c) {
        return repo.save(c);
    }

    public Competition update(Long id, Competition updated) {
        return repo.findById(id).map(c -> {
            c.setName(updated.getName());
            c.setCountry(updated.getCountry());
            c.setType(updated.getType());
            return repo.save(c);
        }).orElseThrow(() -> new RuntimeException("Compétition introuvable"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
