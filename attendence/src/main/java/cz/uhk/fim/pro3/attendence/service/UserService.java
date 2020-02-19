package cz.uhk.fim.pro3.attendence.service;

import cz.uhk.fim.pro3.attendence.dao.UserRepository;
import cz.uhk.fim.pro3.attendence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUser(){
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUserByFirstname(String firstname){
         return userRepository.findByFirstname(firstname);
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public void addUser(User user){ userRepository.save(user); }

    public void deleteUser(int id) { userRepository.deleteById(id);}

    public void updateUser(int id, User user) {
        User oldUser = userRepository.findById(id).get();
        oldUser.setFirstname(user.getFirstname());
        oldUser.setLastname(user.getLastname());
        oldUser.setDateOfBirth(user.getDateOfBirth());
        oldUser.setDateOfCome(user.getDateOfCome());
        oldUser.setDateOfLeave(user.getDateOfLeave());
        oldUser.setSex(user.getSex());
        oldUser.setPiNumber(user.getPiNumber());
        userRepository.save(oldUser);
    }

}
