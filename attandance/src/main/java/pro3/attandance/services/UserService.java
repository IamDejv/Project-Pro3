package pro3.attandance.services;


import org.springframework.stereotype.Service;
import pro3.attandance.model.User;
import pro3.attandance.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUser() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public void updateUser(int id, User user) {
        User oldUser = userRepository.findById(id).get();
        userRepository.save(oldUser);
    }


}
