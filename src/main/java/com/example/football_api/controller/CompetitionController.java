package com.example.football_api.controller;

import com.example.football_api.model.Competition;
import com.example.football_api.service.CompetitionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/competitions")
@Tag(name = "Competitions", description = "Gestion des compétitions")
public class CompetitionController {

    private final CompetitionService service;

    public CompetitionController(CompetitionService service) {
        this.service = service;
    }

    @Operation(summary = "Lister toutes les compétitions (paginé)")
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public Page<Competition> getAll(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public Competition getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Competition create(@RequestBody @Valid Competition competition) {
        return service.create(competition);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Competition update(@PathVariable Long id, @RequestBody @Valid Competition competition) {
        return service.update(id, competition);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
