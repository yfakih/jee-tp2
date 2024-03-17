package com.cafe.jeetp2.repos;

import com.cafe.jeetp2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Transactional
    void deletePatientByNom(String nom);

    Optional<Patient> findPatientByNom(String nom);

}
