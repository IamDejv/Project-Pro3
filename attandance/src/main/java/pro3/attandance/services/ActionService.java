package pro3.attandance.services;


import org.springframework.stereotype.Service;
import pro3.attandance.model.Action;
import pro3.attandance.repository.ActionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ActionService implements BaseService<Action> {

    private final AddressService addressService;

    private final ActionRepository actionRepository;

    public ActionService(ActionRepository actionRepository, AddressService addressService) {
        this.actionRepository = actionRepository;
        this.addressService = addressService;
    }

    @Override
    public List<Action> getAll() {
        return (List<Action>) actionRepository.findAll();
    }

    @Override
    public Optional<Action> getById(int id) {
        return actionRepository.findById(id);
    }

    @Override
    public Action add(Action action) {
        return actionRepository.save(action);
    }

    @Override
    public void deleteById(int id) {
        actionRepository.deleteById(id);
    }

    @Override
    public Action update(int id, Action action) {
        action.setActionsid(id);
        action.setAddress(addressService.update(action.getAddress().getAddresid(), action.getAddress()));
        return actionRepository.save(action);
    }
}
