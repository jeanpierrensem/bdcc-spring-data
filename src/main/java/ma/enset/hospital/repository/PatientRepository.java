package ma.enset.hospital.repository;

import ma.enset.hospital.entity.*;
import org.springframework.data.jpa.repository.*;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
