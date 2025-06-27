package com.example.football_api.service;

import com.example.football_api.model.Stadium;
import com.example.football_api.repository.StadiumRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class StadiumService {

    private final StadiumRepository repo;

    public StadiumService(StadiumRepository repo) {
        this.repo = repo;
    }

    public Page<Stadium> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Stadium getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Stade introuvable"));
    }

    public Stadium create(Stadium stadium) {
        return repo.save(stadium);
    }

    public Stadium update(Long id, Stadium updated) {
        return repo.findById(id).map(s -> {
            s.setName(updated.getName());
            s.setCity(updated.getCity());
            s.setCapacity(updated.getCapacity());
            return repo.save(s);
        }).orElseThrow(() -> new RuntimeException("Stade introuvable"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
