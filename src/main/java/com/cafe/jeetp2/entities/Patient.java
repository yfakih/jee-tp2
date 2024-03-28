package com.cafe.jeetp2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;

@Entity @Table
@Data @AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id
    @SequenceGenerator(name = "generator", initialValue = 2000)
    @GeneratedValue(generator = "generator")
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;
    private boolean sick;
    private int score;
    @OneToMany(mappedBy = "patient",fetch = FetchType.EAGER)
    private Collection<RendezVous> rendezVous;

}
