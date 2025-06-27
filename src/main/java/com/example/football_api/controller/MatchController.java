package com.example.football_api.controller;

import com.example.football_api.model.Match;
import com.example.football_api.service.MatchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "Matches", description = "Gestion des matchs")
public class MatchController {

    private final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @Operation(summary = "Lister tous les matchs (paginé)")
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public Page<Match> getAll(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.getAll(pageable);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public Match getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/team/{teamId}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<Match> getByTeam(@PathVariable Long teamId) {
        return service.getByTeamId(teamId);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Match create(@RequestBody @Valid Match match) {
        return service.create(match);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Match update(@PathVariable Long id, @RequestBody @Valid Match match) {
        return service.update(id, match);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
