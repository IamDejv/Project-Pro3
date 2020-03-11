package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.Hall;
import pro3.attandance.repository.HallRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HallService implements BaseService<Hall> {

    private final HallRepository hallRepository;

    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    @Override
    public List<Hall> getAll() {
        return (List<Hall>) hallRepository.findAll();
    }

    @Override
    public Optional<Hall> getById(int id) {
        return hallRepository.findById(id);
    }

    @Override
    public Hall add(Hall hall) {
        return hallRepository.save(hall);
    }

    @Override
    public void deleteById(int id) {
        hallRepository.deleteById(id);
    }

    @Override
    public Hall update(int id, Hall hall) {
        return hallRepository.save(hall);
    }
}