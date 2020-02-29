package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.SponsorHall;
import pro3.attandance.repository.SponsorHallRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorHallService {

    private final SponsorHallRepository sponsorHallRepository;

    public SponsorHallService(SponsorHallRepository sponsorHallRepository) {
        this.sponsorHallRepository = sponsorHallRepository;
    }

    public List<SponsorHall> getUser() {
        return (List<SponsorHall>) sponsorHallRepository.findAll();
    }

    public Optional<SponsorHall> getUserById(int id) {
        return sponsorHallRepository.findById(id);
    }

    public void addUser(SponsorHall sponsorHall) {
        sponsorHallRepository.save(sponsorHall);
    }

    public void deleteUser(int id) {
        sponsorHallRepository.deleteById(id);
    }

    public void updateUser(int id, SponsorHall sponsorHall) {

    }

}
