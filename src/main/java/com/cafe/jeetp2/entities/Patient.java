package com.cafe.jeetp2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity @Table
@Data @AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id
    @SequenceGenerator(name = "generator", initialValue = 2000)
    @GeneratedValue(generator = "generator")
    private Long id;
    private String nom;
    private LocalDate dateOfBirth;
    private boolean sick;
    private int score;
}
