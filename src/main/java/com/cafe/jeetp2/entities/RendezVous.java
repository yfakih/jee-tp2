package com.cafe.jeetp2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity @AllArgsConstructor
@NoArgsConstructor
public class RendezVous {
    @Id
    @SequenceGenerator(name = "RendGenerator", initialValue = 100)
    @GeneratedValue(generator = "RendGenerator")
    private Long id;
    @Temporal(TemporalType.DATE)
    private LocalDate localDate;
    @Temporal(TemporalType.TIME)
    private LocalTime localTime;
    private StatusRdv status ;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
