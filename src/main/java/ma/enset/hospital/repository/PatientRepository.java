package ma.enset.hospital.repository;

import ma.enset.hospital.entity.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface PatientRepository extends JpaRepository<Patient, Long> {
List<Patient> findByNameContaining(String kw);
}
