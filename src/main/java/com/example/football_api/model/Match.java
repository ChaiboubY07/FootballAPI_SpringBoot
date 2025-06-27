package com.example.football_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime matchDate;

    @Min(0)
    private int homeScore;

    @Min(0)
    private int awayScore;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

}
