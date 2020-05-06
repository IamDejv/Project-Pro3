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
    public List<Role> get() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Role> getById(@PathVariable("id") Integer id) {
        return roleService.getById(id);
    }
}
