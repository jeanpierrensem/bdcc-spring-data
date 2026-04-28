package ma.enset.hospital.web;

import ma.enset.hospital.entity.*;
import ma.enset.hospital.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/consultations", produces = "application/json")
public class ConsultationController {
ConsultationRepository consultationRepository ;

public ConsultationController(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
}

   @GetMapping
   public List<Consultation> getConsultations(){
        return consultationRepository.findAll();
    }

    @PostMapping
    public Consultation saveConsultation (@RequestBody Consultation consultation){
        return consultationRepository.save(consultation);
    }

    @PostMapping(value = "/all")
    public List<Consultation> saveAllConsultation (@RequestBody List<Consultation> consultation){
        return consultationRepository.saveAll(consultation);
    }


    @PutMapping
    public Consultation updateConsultation(@RequestBody  Consultation consultation){
       return  consultationRepository.save(consultation);
    }

    @DeleteMapping(value = "/del/{id}")
    public void deleteConsultation (@PathVariable  Long id){
        Consultation toDelete = consultationRepository.findById(id).orElseThrow(()-> new RuntimeException("Consultation n'existe pas"));
        consultationRepository.delete(toDelete);
    }
@GetMapping(value = "/{id}")
public Consultation findById(@PathVariable Long id){
        return consultationRepository.findById(id).orElseThrow(()-> new RuntimeException("Consultation n'existe pas"));
    }


    //RendezVousList
    

}
