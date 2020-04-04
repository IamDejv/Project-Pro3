package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.UserAction;
import pro3.attandance.repository.UserActionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserActionService implements BaseService<UserAction> {

    private final UserActionRepository userActionRepository;

    public UserActionService(UserActionRepository userActionRepository) {
        this.userActionRepository = userActionRepository;
    }

    @Override
    public List<UserAction> getAll() {
        return (List<UserAction>) userActionRepository.findAll();
    }

    @Override
    public Optional<UserAction> getById(int id) {
        return userActionRepository.findById(id);
    }

    @Override
    public UserAction add(UserAction userAction) {
        return userActionRepository.save(userAction);
    }

    @Override
    public void deleteById(int id) {
        userActionRepository.deleteById(id);
    }

    @Override
    public UserAction update(int id, UserAction userAction) {
        return userActionRepository.save(userAction);
    }

    public List<UserAction> getByActionId(int id) {
        return userActionRepository.findAllByActionActionsid(id);
    }

    public List<Integer> getUsersAction(int id) {
        List<Integer> actionsId = new ArrayList<>();
        List<UserAction> userActions = userActionRepository.getUserActionsByUser_Userid(id);
        for (UserAction userAction: userActions) {
            actionsId.add(userAction.getActionid());
        }
        return actionsId;
    }
}
