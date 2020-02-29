package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.Company;
import pro3.attandance.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getUser() {
        return (List<Company>) companyRepository.findAll();
    }

    public Optional<Company> getUserById(int id) {
        return companyRepository.findById(id);
    }

    public void addUser(Company company) {
        companyRepository.save(company);
    }

    public void deleteUser(int id) {
        companyRepository.deleteById(id);
    }

    public void updateUser(int id, Company company) {

    }

}
