package ma.enset.usershab.services;

import ma.enset.usershab.entities.*;

public interface USerService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUsername(String username);
    void addRoleToUser(String username, String rolename);
    Role findRoleByRoleName(String roleName);
    User authenticate(String username, String password) ;

}
