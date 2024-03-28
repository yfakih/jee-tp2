package com.cafe.jeetp2;

import com.cafe.jeetp2.entities.Patient;
import com.cafe.jeetp2.repos.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@AllArgsConstructor
public class JeeTp2Application {

    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(JeeTp2Application.class, args);
    }

//    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println(patientRepository.findPatientByNom("John").get());

            Patient emily = patientRepository.findPatientByNom("Emily").get();
            emily.setDateOfBirth(LocalDate.of(2001, 11, 30));

            patientRepository.save(emily);
        };
    }

}
