package ma.enset.hospital.service;

import ma.enset.hospital.entity.*;
import ma.enset.hospital.repository.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PatientController{
    PatientRepository patientRepository;
    public PatientController(PatientRepository patientRepository) {
    this.patientRepository = patientRepository ;
    }

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody  Patient patient) {
        return patientRepository.save(patient);
    }

    @DeleteMapping("/patients/del/{id}")
    public void deletePatient(@PathVariable Long id) {
        Patient toDelete = patientRepository.findById(id).orElseThrow(()->null);
       if(toDelete == null) return;
        patientRepository.delete(toDelete);
    }

   @GetMapping("/patients/{id}")
    public Patient findPatientById(@PathVariable  Long id) {
        Patient toReturn  =  patientRepository.findById(id).orElseThrow(()->null);
        if(toReturn==null) return null;
        return toReturn ;
    }

   @GetMapping ("/patients")
    public List<Patient> getPateints() {
        return patientRepository.findAll();
    }


}
