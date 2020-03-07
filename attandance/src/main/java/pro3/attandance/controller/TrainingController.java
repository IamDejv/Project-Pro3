package pro3.attandance.controller;

import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.Training;
import pro3.attandance.model.User;
import pro3.attandance.services.TrainingService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/training")
public class TrainingController {

    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping
    public List<Training> getUser() {
        return trainingService.getUser();
    }

    @GetMapping("/{id}")
    public Optional<Training> getUserById(@PathVariable("id") Integer id) {
        return trainingService.getUserById(id);
    }

    @PostMapping(produces = "application/json")
    public void addUser(@RequestBody Training training) {
        trainingService.addUser(training);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable ("id") Integer id){
        trainingService.deleteUser(id);
    }

    @PutMapping(produces = "application/json")
    public void updateUser(@RequestBody Training training){
        trainingService.updateUser(training.getTrainingid(), training);
    }
}
