package com.cafe.jeetp2.repos;

import com.cafe.jeetp2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<Patient, Long> {


}
