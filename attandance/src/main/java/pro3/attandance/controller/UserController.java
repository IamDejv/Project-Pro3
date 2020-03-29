package pro3.attandance.controller;


import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.User;
import pro3.attandance.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void addUser(@RequestBody User user) {
        userService.add(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteById(id);
    }

    @PutMapping(produces = "application/json")
    public void updateUser(@RequestBody User user) {
        userService.update(user.getUserid(), user);
    }

    @GetMapping("/usernames")
    public List<String> getUsernames() {
        return userService.getAllUsernames();
    }
}


