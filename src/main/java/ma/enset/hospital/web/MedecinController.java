package ma.enset.hospital.web;

import ma.enset.hospital.entity.*;
import ma.enset.hospital.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/medecins", produces = "application/json")
public class MedecinController {
MedecinRepository medecinRepository ;

public MedecinController(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
}

   @GetMapping
   public List<Medecin> getMedecins(){
        return medecinRepository.findAll();
    }

    @PostMapping
    public Medecin saveMdedecin (@RequestBody Medecin medecin){
        return medecinRepository.save(medecin);
    }

    @PostMapping(value = "/all")
    public List<Medecin> saveAllMedecin (@RequestBody List<Medecin> medecin){
        return medecinRepository.saveAll(medecin);
    }

    @PutMapping
    public Medecin updateMedecin(@RequestBody  Medecin medecin){
       return  medecinRepository.save(medecin);
    }

    @DeleteMapping(value = "/del/{id}")
    public void deleteMedecing (@PathVariable  Long id){
        Medecin toDelete = medecinRepository.findById(id).orElseThrow(()-> new RuntimeException("Medecin n'existe pas"));
        medecinRepository.delete(toDelete);
    }
@GetMapping(value = "/{id}")
public Medecin findById(@PathVariable Long id){
        return medecinRepository.findById(id).orElseThrow(()-> new RuntimeException("Medecin n'existe pas"));
    }

    @GetMapping(value ="/find")
    List<Medecin> findPatientsByName(@RequestParam String kw){
        return medecinRepository.findByNameContaining(kw);
    }


    //RendezVousList


}
