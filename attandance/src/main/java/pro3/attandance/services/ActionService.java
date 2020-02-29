package pro3.attandance.services;


import org.springframework.stereotype.Service;
import pro3.attandance.model.Action;
import pro3.attandance.repository.ActionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ActionService {

    private final ActionRepository actionRepository;

    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public List<Action> getUser() {
        return (List<Action>) actionRepository.findAll();
    }

    public Optional<Action> getUserById(int id) {
        return actionRepository.findById(id);
    }

    public void addUser(Action action) {
        actionRepository.save(action);
    }

    public void deleteUser(int id) {
        actionRepository.deleteById(id);
    }

    public void updateUser(int id, Action action) {

    }


}
