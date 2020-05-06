package pro3.attandance.apiController;

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
    public List<UserAction> get() {
        return userActionService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<UserAction> getById(@PathVariable("id") Integer id) {
        return userActionService.getById(id);
    }

    @PostMapping
    public UserAction add(@RequestBody UserAction userAction) {
        userActionService.add(userAction);
        return userAction;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userActionService.deleteById(id);
    }

    @PutMapping(produces = "application/json")
    public UserAction update(@RequestBody UserAction userAction) {
        userActionService.update(userAction.getUseractionid(), userAction);
        return userAction;
    }
}
