package pro3.attandance.controller;

import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.Action;
import pro3.attandance.services.ActionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/action")
public class ActionController {

    private final ActionService actionService;

    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @GetMapping
    public List<Action> getUser() {
        return actionService.getUser();
    }

    @GetMapping("/{id}")
    public Optional<Action> getUserById(@PathVariable("id") Integer id) {
        return actionService.getUserById(id);
    }

    @PostMapping(produces = "application/json")
    public void addUser(@RequestBody Action action) {
        actionService.addUser(action);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        actionService.deleteUser(id);
    }

    @PutMapping(produces = "application/json")
    public void updateUser(@RequestBody Action action) {
        actionService.updateUser(action.getActionsid(), action);
    }
}
