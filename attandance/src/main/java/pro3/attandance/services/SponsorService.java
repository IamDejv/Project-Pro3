package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.Sponsor;
import pro3.attandance.repository.SponsorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorService implements BaseService<Sponsor> {

    private final SponsorRepository sponsorRepository;

    public SponsorService(SponsorRepository sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }

    @Override
    public List<Sponsor> getAll() {
        return (List<Sponsor>) sponsorRepository.findAll();
    }

    @Override
    public Optional<Sponsor> getById(int id) {
        return sponsorRepository.findById(id);
    }

    @Override
    public Sponsor add(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    @Override
    public void deleteById(int id) {
        sponsorRepository.deleteById(id);
    }

    @Override
    public Sponsor update(int id, Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }
}
