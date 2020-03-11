package pro3.attandance.services;


import org.springframework.stereotype.Service;
import pro3.attandance.model.User;
import pro3.attandance.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements BaseService<User> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(int id, User user) {
        return userRepository.save(user);
    }
}
