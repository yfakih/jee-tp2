package com.cafe.jeetp2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor
@NoArgsConstructor
public class Medecin {
    @Id
    @SequenceGenerator(name = "MedGenerator", initialValue = 1000)
    @GeneratedValue(generator = "MedGenerator")
    private Long id;
    private String nom;
    private String specialite;
    @OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;
}
