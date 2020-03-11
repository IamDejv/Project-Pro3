package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.SponsorHall;
import pro3.attandance.repository.SponsorHallRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorHallService implements BaseService<SponsorHall> {

    private final SponsorHallRepository sponsorHallRepository;

    public SponsorHallService(SponsorHallRepository sponsorHallRepository) {
        this.sponsorHallRepository = sponsorHallRepository;
    }

    @Override
    public List<SponsorHall> getAll() {
        return (List<SponsorHall>) sponsorHallRepository.findAll();
    }

    @Override
    public Optional<SponsorHall> getById(int id) {
        return sponsorHallRepository.findById(id);
    }

    @Override
    public SponsorHall add(SponsorHall sponsorHall) {
        return sponsorHallRepository.save(sponsorHall);
    }

    @Override
    public void deleteById(int id) {
        sponsorHallRepository.deleteById(id);
    }

    @Override
    public SponsorHall update(int id, SponsorHall sponsorHall) {
        return sponsorHallRepository.save(sponsorHall);
    }
}
