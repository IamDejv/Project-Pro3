package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.Training;
import pro3.attandance.model.UserAction;
import pro3.attandance.repository.TrainingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingService implements BaseService<Training> {

    private final TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public List<Training> getAll() {
        return (List<Training>) trainingRepository.findAll();
    }

    @Override
    public Optional<Training> getById(int id) {
        return trainingRepository.findById(id);
    }

    @Override
    public Training add(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public void deleteById(int id) {
        trainingRepository.deleteById(id);
    }

    @Override
    public Training update(int id, Training training) {
        return trainingRepository.save(training);
    }

    public List<Integer> getUsersTraining(int id) {
        List<Integer> trainingIds = new ArrayList<>();
        List<Training> trainings = trainingRepository.getAllByUser_Userid(id);
        for (Training training: trainings) {
            trainingIds.add(training.getTrainingid());
        }
        return trainingIds;
    }
}
