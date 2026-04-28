package ma.enset.hospital;

import ma.enset.hospital.entity.*;
import ma.enset.hospital.repository.*;
import ma.enset.hospital.web.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

import java.util.*;

@SpringBootApplication
public class BdccHospitalSpringDataApplication {
  PatientRepository patientRepository ;
   RendezVousController rendezVousController;

    public BdccHospitalSpringDataApplication(PatientRepository patientRepository, RendezVousController rendezVousController) {
        this.patientRepository = patientRepository;
        this.rendezVousController = rendezVousController;
    }



    public static void main(String[] args) {
        SpringApplication.run(BdccHospitalSpringDataApplication.class, args);
    }

    @Bean
    CommandLineRunner start(String...args){
        return args1 -> {
            Patient patient = Patient.builder()
                    .id(null)
                    .name("jean-Pierre")
                    .dateNaissance(new Date())
                    .malade(false)
                    .build();
            patientRepository.save(patient);
            Patient patient1 = Patient.builder()
                    .id(null)
                    .name("-jean-Paul")
                    .dateNaissance(new Date())
                    .malade(true)
                    .build();
            patientRepository.save(patient1);
            Patient patient2 = Patient.builder()
                    .id(null)
                    .name("Herve")
                    .dateNaissance(new Date())
                    .malade(false)
                    .build();
            patientRepository.save(patient2);

            RendezVs rendezVs =RendezVs.builder()
                    .id(null)
                    .date(new Date())
                    .patient(patient)
                    .statuts(StatutRdv.PENDING)
                    .medecin(null)
                    .consultation(null).build();;

            RendezVs rendezVs1 = RendezVs.builder()
                    .id(null)
                    .date(new Date())
                    .patient(patient1)
                    .statuts(StatutRdv.PENDING)
                    .medecin(null)
                    .consultation(null).build();

            RendezVs  rendezVs2 = RendezVs.builder()
                    .id(null)
                    .date(new Date())
                    .patient(patient2)
                    .statuts(StatutRdv.PENDING)
                    .medecin(null)
                    .consultation(null).build();

            rendezVousController.saveAllRendezVous(List.of(rendezVs, rendezVs1, rendezVs2));



        };

    }


}
