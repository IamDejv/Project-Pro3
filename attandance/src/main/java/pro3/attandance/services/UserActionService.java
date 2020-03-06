package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.UserAction;
import pro3.attandance.repository.UserActionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserActionService {

    private final UserActionRepository userActionRepository;

    public UserActionService(UserActionRepository userActionRepository) {
        this.userActionRepository = userActionRepository;
    }

    public List<UserAction> getUser() {
        return (List<UserAction>) userActionRepository.findAll();
    }

    public Optional<UserAction> getUserById(int id) {
        return userActionRepository.findById(id);
    }

    public void addUser(UserAction userAction) {
        userActionRepository.save(userAction);
    }

    public void deleteUser(int id) {
        userActionRepository.deleteById(id);
    }

    public void updateUser(int id, UserAction userAction) {

    }

}
