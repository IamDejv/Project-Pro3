package pro3.attandance.apiController;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pro3.attandance.model.Person;
import pro3.attandance.model.User;
import pro3.attandance.model.UserAction;
import pro3.attandance.services.PersonService;
import pro3.attandance.services.UserActionService;
import pro3.attandance.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    private final UserActionService userActionService;

    private final PersonService personService;

    public UserController(UserService userService, UserActionService userActionService, PersonService personService) {
        this.userService = userService;
        this.userActionService = userActionService;
        this.personService = personService;
    }

    @GetMapping
    public List<User> get() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public User add(@RequestBody User user) {
        try{
            if(personService.getPersonByEmail(user.getPerson().getContactInfo().getEmail()) == null) {
                    if (userService.getByUsername(user.getUsername()) == null) {
                        userService.add(user);
                    } else {
                        throw new Exception("Uživatelské jméno bylo použito jiným uživatelem");
                    }
            } else {
                throw new Exception("Email byl použit jiným uživatelem");
            }
            return user;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage(), e);
        }
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") int id, @RequestBody User user) {
        userService.update(id, user);
        return user;
    }

    @GetMapping("/usernames")
    public List<String> getUsernames() {
        return userService.getAllUsernames();
    }

    @GetMapping("/action/{id}")
    public List<User> getUsersInActionId(@PathVariable("id") int id) {
        List<UserAction> userActions = userActionService.getByActionId(id);
        List<User> users = new ArrayList<>();
        for (UserAction userAction : userActions) {
            users.add(getById(userAction.getUserid()).orElse(null));
        }
        return users;
    }
}


