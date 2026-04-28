package ma.enset.hospital.web;

import ma.enset.hospital.entity.*;
import ma.enset.hospital.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/rendezvous", produces = "application/json")
public class RendezVousController {
RendezVousRepository rendezVousRepository ;

public RendezVousController(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
}

   @GetMapping
   public List<RendezVs> getRendezVous(){
        return rendezVousRepository.findAll();
    }

    @PostMapping
    public RendezVs saveRendezVous (@RequestBody RendezVs rendezVs){
        return rendezVousRepository.save(rendezVs);
    }

    @PostMapping(value = "/all")
    public List<RendezVs> saveAllRendezVous (@RequestBody List<RendezVs> rendezVs){
        return rendezVousRepository.saveAll(rendezVs);
    }


    @PutMapping
    public RendezVs updateRendezVous(@RequestBody  RendezVs rendezVs){
       return  rendezVousRepository.save(rendezVs);
    }

    @DeleteMapping(value = "/del/{id}")
    public void deleteRendezVous (@PathVariable  Long id){
        RendezVs toDelete = rendezVousRepository.findById(id).orElseThrow(()-> new RuntimeException("Rendez-vous n'existe pas"));
        rendezVousRepository.delete(toDelete);
    }
@GetMapping(value = "/{id}")
public RendezVs findById(@PathVariable Long id){
        return rendezVousRepository.findById(id).orElseThrow(()-> new RuntimeException("Rendez-vous n'existe pas"));
    }


   //findby ¨Patient
    // find by Medecin
    //find by consultationn
}
