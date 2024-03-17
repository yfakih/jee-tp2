package com.cafe.jeetp2;

import com.cafe.jeetp2.entities.Patient;
import com.cafe.jeetp2.repos.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@AllArgsConstructor
public class JeeTp2Application {

    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(JeeTp2Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            patientRepository.save(new Patient(null, "Ali", LocalDate.of(1990, 5, 15), true, 75,null));
            patientRepository.save(new Patient(null, "Sarah", LocalDate.of(1985, 8, 22), false, 90,null));
            patientRepository.save(new Patient(null, "John", LocalDate.of(1978, 3, 7), true, 60,null));
            patientRepository.save(new Patient(null, "Emily", LocalDate.of(2002, 11, 30), false, 80,null));
            patientRepository.save(new Patient(null, "David", LocalDate.of(1995, 6, 18), true, 45,null));
            patientRepository.save(new Patient(null, "Maria", LocalDate.of(1980, 9, 25), false, 70,null));

            patientRepository.deletePatientByNom("Sarah");

            System.out.println(patientRepository.findPatientByNom("John").get());

            Patient emily = patientRepository.findPatientByNom("Emily").get();
            emily.setDateOfBirth(LocalDate.of(2001, 11, 30));

            patientRepository.save(emily);
        };
    }

}
