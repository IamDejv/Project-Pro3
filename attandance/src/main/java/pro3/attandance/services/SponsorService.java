package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.Sponsor;
import pro3.attandance.repository.SponsorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorService {

    private final SponsorRepository sponsorRepository;

    public SponsorService(SponsorRepository sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }

    public List<Sponsor> getUser() {
        return (List<Sponsor>) sponsorRepository.findAll();
    }

    public Optional<Sponsor> getUserById(int id) {
        return sponsorRepository.findById(id);
    }

    public void addUser(Sponsor sponsor) {
        sponsorRepository.save(sponsor);
    }

    public void deleteUser(int id) {
        sponsorRepository.deleteById(id);
    }

    public void updateUser(int id, Sponsor sponsor) {

    }

}
