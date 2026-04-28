package ma.enset.hospital.web;

import ma.enset.hospital.entity.*;
import ma.enset.hospital.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/patients", produces = "application/json")
public class PatientController{
    PatientRepository patientRepository;
    public PatientController(PatientRepository patientRepository) {
    this.patientRepository = patientRepository ;
    }

    @GetMapping
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @PostMapping
    public Patient savePatient(@RequestBody  Patient patient) {
        return patientRepository.save(patient);
    }

    @PutMapping
   Patient updatePatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    @DeleteMapping("/del/{id}")
    public void deletePatient(@PathVariable Long id) {
        Patient toDelete = patientRepository.findById(id).orElseThrow(()->null);
       if(toDelete == null) return;
        patientRepository.delete(toDelete);
    }
    @GetMapping(value ="/find")
    List<Patient> findPatientsByName(@RequestParam String kw){
        return patientRepository.findByNameContaining(kw);
    }

   @GetMapping("/patients/{id}")
    public Patient findPatientById(@PathVariable  Long id) {
        Patient toReturn  =  patientRepository.findById(id).orElseThrow(()->null);
        if(toReturn==null) return null;
        return toReturn ;
    }






}
