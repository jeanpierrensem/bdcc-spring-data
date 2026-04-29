package ma.enset.usershab.services;

import jakarta.transaction.*;
import lombok.*;
import ma.enset.usershab.entities.*;
import ma.enset.usershab.repositories.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class USerServiceImpl implements USerService {
    private UserRepository userRepository ;
    private RoleRepository roleRepository;


    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
    Role roleToAdd = roleRepository.findByRoleName(rolename);
    User user = findUserByUsername(username);
    if (user.getRoles() !=null)
        user.getRoles().add(roleToAdd);
        roleToAdd.getUsers().add(user);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return  roleRepository.findByRoleName(roleName);
    }

    @Override
    public User authenticate(String username, String password) {

        User user = findUserByUsername(username);
        if(user==null)   throw new RuntimeException("Bad credentiat");
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad credentiat");
    }
}
