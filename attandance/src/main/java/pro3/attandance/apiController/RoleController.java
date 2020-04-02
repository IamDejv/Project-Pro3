package pro3.attandance.apiController;

import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.Role;
import pro3.attandance.services.RoleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getUser() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Role> getUserById(@PathVariable("id") Integer id) {
        return roleService.getById(id);
    }

    @PostMapping(produces = "application/json")
    public void addUser(@RequestBody Role role) {
        roleService.add(role);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        roleService.deleteById(id);
    }

    @PutMapping(produces = "application/json")
    public void updateUser(@RequestBody Role role) {
        roleService.update(role.getRoleid(), role);
    }


}
