package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.Training;
import pro3.attandance.repository.TrainingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<Training> getUser() {
        return (List<Training>) trainingRepository.findAll();
    }

    public Optional<Training> getUserById(int id) {
        return trainingRepository.findById(id);
    }

    public void addUser(Training training) {
        trainingRepository.save(training);
    }

    public void deleteUser(int id) {
        trainingRepository.deleteById(id);
    }

    public void updateUser(int id, Training training) {

    }

}
