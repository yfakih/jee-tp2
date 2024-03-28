package com.cafe.jeetp2.service;

import com.cafe.jeetp2.entities.Patient;
import com.cafe.jeetp2.repos.PatientRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    private PatientRepository patientRepository;

    public Page<Patient> fetchAllPatients(int page, int size){
        return patientRepository.findAll(PageRequest.of(page, size));
    }

    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }

    public Page<Patient> findPatientsByKw(String kw, Pageable pageable) {
        return patientRepository.findPatientByNomContainingIgnoreCase(kw, pageable);
    }
    public void updatePatient(Patient patient){
        patientRepository.saveAndFlush(patient);
    }

    public Patient getPatient(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
}
