package pro3.attandance.apiController;

import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.Company;
import pro3.attandance.model.Role;
import pro3.attandance.services.CompanyService;
import pro3.attandance.services.RoleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> get() {
        return companyService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Company> getById(@PathVariable("id") Integer id) {
        return companyService.getById(id);
    }

    @PostMapping(produces = "application/json")
    public void add(@RequestBody Company company) {
        companyService.add(company);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        companyService.deleteById(id);
    }

    @PutMapping(produces = "application/json")
    public void update(@RequestBody Company company) {
        companyService.update(company.getCompanyid(), company);
    }


}
