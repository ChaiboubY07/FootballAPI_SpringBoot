package com.example.football_api.service;

import com.example.football_api.dto.*;
import com.example.football_api.model.*;
import com.example.football_api.repository.UserRepository;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthenticationService {
    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtService jwt;
    private final AuthenticationManager authManager;

    public AuthenticationService(UserRepository repo, PasswordEncoder encoder, JwtService jwt, AuthenticationManager authManager) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwt = jwt;
        this.authManager = authManager;
    }

    public void register(RegisterRequest request) {
        if (repo.existsByUsername(request.username())) {
            throw new RuntimeException("Username already exists");
        }
    
        Set<Role> roles = request.roles().stream().map(Role::valueOf).collect(Collectors.toSet());
    
        var user = User.builder()
                .username(request.username())
                .password(encoder.encode(request.password()))
                .roles(roles)
                .build();
    
        repo.save(user);
    }    

    public AuthResponse login(AuthRequest request) {
        System.out.println("Tentative de login pour: " + request.username());
    
        try {
            authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.username(),
                    request.password()
                )
            );
            System.out.println("Authentification réussie !");
        } catch (Exception e) {
            System.out.println("Erreur pendant authenticationManager.authenticate : " + e.getMessage());
            throw e;
        }
    
        User user = repo.findByUsername(request.username())
            .orElseThrow(() -> new RuntimeException("User not found"));
    
        System.out.println("Utilisateur trouvé en base : " + user.getUsername());
    
        String token = jwt.generateToken(user);
        System.out.println("Token généré avec succès");
    
        return new AuthResponse(token);
    }
    
}
