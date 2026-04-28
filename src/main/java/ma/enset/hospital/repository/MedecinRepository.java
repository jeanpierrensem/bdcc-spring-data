package ma.enset.hospital.repository;

import ma.enset.hospital.entity.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    List<Medecin> findByNameContaining(String kw);
}
