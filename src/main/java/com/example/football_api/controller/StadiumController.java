package com.example.football_api.controller;

import com.example.football_api.model.Stadium;
import com.example.football_api.service.StadiumService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/stadiums")
@Tag(name = "Stadiums", description = "Gestion des stades")
public class StadiumController {

    private final StadiumService service;

    public StadiumController(StadiumService service) {
        this.service = service;
    }

    @Operation(summary = "Lister tous les stades (paginé)")
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public Page<Stadium> getAll(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Stadium getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Stadium create(@RequestBody @Valid Stadium stadium) {
        return service.create(stadium);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Stadium update(@PathVariable Long id, @RequestBody @Valid Stadium stadium) {
        return service.update(id, stadium);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
