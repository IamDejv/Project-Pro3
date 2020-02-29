package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.Hall;
import pro3.attandance.repository.HallRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HallService {

    private final HallRepository hallRepository;

    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public List<Hall> getUser() {
        return (List<Hall>) hallRepository.findAll();
    }

    public Optional<Hall> getUserById(int id) {
        return hallRepository.findById(id);
    }

    public void addUser(Hall hall) {
        hallRepository.save(hall);
    }

    public void deleteUser(int id) {
        hallRepository.deleteById(id);
    }

    public void updateUser(int id, Hall hall) {

    }
}