package com.cafe.jeetp2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Consultation {

    @Id
    @SequenceGenerator(name = "ConsGenerator", initialValue = 10000)
    @GeneratedValue(generator = "ConsGenerator")
    private Long id;
    private LocalDate localDate;
    private String rapport;
    private StatusRdv status ;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne
    RendezVous rendezVous;

}
