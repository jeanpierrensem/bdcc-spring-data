package ma.enset.hospital.repository;

import ma.enset.hospital.entity.*;
import org.springframework.data.jpa.repository.*;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
