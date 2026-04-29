package ma.enset.usershab.repositories;

import ma.enset.usershab.entities.*;
import org.springframework.data.jpa.repository.*;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
