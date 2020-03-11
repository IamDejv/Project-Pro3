package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.Company;
import pro3.attandance.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements BaseService<Company> {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAll() {
        return (List<Company>) companyRepository.findAll();
    }

    @Override
    public Optional<Company> getById(int id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company add(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteById(int id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company update(int id, Company company) {
        return companyRepository.save(company);
    }
}
