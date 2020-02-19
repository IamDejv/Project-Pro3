package cz.uhk.fim.pro3.attendence.controller;

import cz.uhk.fim.pro3.attendence.model.User;
import cz.uhk.fim.pro3.attendence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping(produces = "application/json")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable ("id") Integer id){
        userService.deleteUser(id);
    }

    @PutMapping(produces = "application/json")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user.getUserid(), user);
    }
}


