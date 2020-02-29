package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.Role;
import pro3.attandance.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {


    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getUser() {
        return (List<Role>) roleRepository.findAll();
    }

    public Optional<Role> getUserById(int id) {
        return roleRepository.findById(id);
    }

    public void addUser(Role role) {
        roleRepository.save(role);
    }

    public void deleteUser(int id) {
        roleRepository.deleteById(id);
    }

    public void updateUser(int id, Role role) {

    }

}
