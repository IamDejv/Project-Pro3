package pro3.attandance.controller;

import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.UserAction;
import pro3.attandance.services.UserActionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/useraction")
public class UserActionController {

    private UserActionService userActionService;

    public UserActionController(UserActionService userActionService) {
        this.userActionService = userActionService;
    }

    @GetMapping
    public List<UserAction> getUser() {
        return userActionService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<UserAction> getUserById(@PathVariable("id") Integer id) {
        return userActionService.getById(id);
    }

    @PostMapping
    public void addUser(@RequestBody UserAction userAction) {
        userActionService.add(userAction);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userActionService.deleteById(id);
    }

    @PutMapping(produces = "application/json")
    public void updateUser(@RequestBody UserAction userAction) {
        userActionService.update(userAction.getUseractionid(), userAction);
    }
}
