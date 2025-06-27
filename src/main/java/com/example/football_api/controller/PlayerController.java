package com.example.football_api.controller;

import com.example.football_api.model.Player;
import com.example.football_api.service.PlayerService;

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
@RequestMapping("/api/players")
@Tag(name = "Players", description = "Gestion des joueurs")
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @Operation(summary = "Lister tous les joueurs (paginé)")
    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
        public Page<Player> getAll(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Player getById(@PathVariable Long id) {
        return service.getPlayerById(id);
    }

    @GetMapping("/team/{teamId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Player> getByTeam(@PathVariable Long teamId) {
        return service.getPlayersByTeam(teamId);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Player create(@RequestBody @Valid Player player) {
        return service.createPlayer(player);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Player update(@PathVariable Long id, @RequestBody @Valid Player player) {
        return service.updatePlayer(id, player);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) {
        service.deletePlayer(id);
    }
}
