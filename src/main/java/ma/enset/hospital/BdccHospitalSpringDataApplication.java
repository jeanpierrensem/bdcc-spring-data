package ma.enset.hospital;

import ma.enset.hospital.entity.*;
import ma.enset.hospital.repository.*;
import ma.enset.hospital.service.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

import java.util.*;

@SpringBootApplication
public class BdccHospitalSpringDataApplication {
  PatientRepository patientRepository ;

    public BdccHospitalSpringDataApplication(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BdccHospitalSpringDataApplication.class, args);
    }

    @Bean
    CommandLineRunner start(String...args){
        return args1 -> {
         patientRepository.save( Patient.builder()
                    .id(null)
                    .name("jean-Pierre")
                     .dateNaissance(new Date())
                    .malade(false)
                    .build());
            patientRepository.save( Patient.builder()
                    .id(null)
                    .name("Paul")
                    .dateNaissance(new Date())
                    .malade(true)
                    .build());
            patientRepository.save( Patient.builder()
                    .id(null)
                    .name("Herve")
                    .dateNaissance(new Date())
                    .malade(false)
                    .build());
        };
    }


}
