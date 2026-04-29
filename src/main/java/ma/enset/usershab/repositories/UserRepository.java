package ma.enset.usershab.repositories;

import ma.enset.usershab.entities.*;
import org.springframework.data.jpa.repository.*;

public interface UserRepository extends JpaRepository <User, String> {
    User findByUsername(String username);
}
