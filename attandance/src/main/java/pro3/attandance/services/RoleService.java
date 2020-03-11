package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.Role;
import pro3.attandance.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements BaseService<Role> {


    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Optional<Role> getById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role update(int id, Role role) {
        return roleRepository.save(role);
    }
}
