package ma.enset.hospital.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom ;
    private String email;
    private String specialite;
    @OneToMany(mappedBy = "medecin" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<RendezVs> rendezVsList;
}
