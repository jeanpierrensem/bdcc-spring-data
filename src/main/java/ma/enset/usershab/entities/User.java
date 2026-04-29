package ma.enset.usershab.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
@Builder
public class User {

    @Id
    private String userId;
    @Column(unique = true, length = 20)
    private String username;
    private String password;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

}
