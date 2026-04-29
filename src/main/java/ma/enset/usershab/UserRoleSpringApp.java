package ma.enset.usershab;

import lombok.*;
import ma.enset.patients.entity.*;
import ma.enset.patients.web.*;
import ma.enset.usershab.entities.*;
import ma.enset.usershab.entities.Role;
import ma.enset.usershab.services.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

import java.util.stream.*;

@SpringBootApplication
@AllArgsConstructor
public class UserRoleSpringApp {

     private USerService uSerService ;

    public static void main(String[] args) {
        SpringApplication.run(UserRoleSpringApp.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args-> {
            //ajouter user
            User user1 = User.builder()
                    .username("user1")
                    .password("12345")
                    .roles(null)
                    .build();
            User admin = User.builder()
                    .username("admin")
                    .password("12345")
                    .roles(null)
                    .build();
            uSerService.addNewUser(user1);
            uSerService.addNewUser(admin);
            //Ajouter role
            Stream.of("STUDENT", "USER", "ADMIN").forEach(r->{
                Role role1 = Role.builder()
                        .roleName(r)
                    .build();
             uSerService.addNewRole(role1);
            });

        uSerService.addRoleToUser("user1", "STUDENT");
        uSerService.addRoleToUser("user1", "USER");
            uSerService.addRoleToUser("admin", "STUDENT");
            uSerService.addRoleToUser("admin", "ADMIN");




        };


    }
}
