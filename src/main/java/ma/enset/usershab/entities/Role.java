package ma.enset.usershab.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(unique = true, length = 20)
    private String roleName ;
    @Column(name = "DESCRIPTION")
    private String desc ;
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();
}
