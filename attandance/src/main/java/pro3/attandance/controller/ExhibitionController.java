package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pro3.attandance.model.Action;
import pro3.attandance.model.User;
import pro3.attandance.model.UserAction;
import pro3.attandance.services.ActionService;
import pro3.attandance.services.UserActionService;
import pro3.attandance.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ExhibitionController {

    private ActionService actionService;

    private UserActionService userActionService;

    private UserService userService;

    public ExhibitionController (ActionService actionService, UserActionService userActionService, UserService userService) {
        this.actionService = actionService;
        this.userActionService = userActionService;
        this.userService = userService;
    }

    @GetMapping("/vystoupeni")
    public String exhibition(){
        return "exhibition/index";
    }

    @GetMapping("/action/{id}")
    public String actionDetail(@PathVariable("id") int id, Model model) {

        Optional<Action> actionOpt = actionService.getById(id);
        List<UserAction> userActions = userActionService.getByActionId(id);
        List<User> users = new ArrayList<>();
        for (UserAction userAction : userActions) {
            users.add(userService.getById(userAction.getUserid()).orElse(null));
        }
        Action action;
        action = actionOpt.orElse(null);
        model.addAttribute("actionid", id);
        model.addAttribute("action", action);
        model.addAttribute("users", users.toArray());
        return "exhibition/detail";
    }

    @GetMapping("/vystoupeni/add")
    public String actionForm() {
        return "exhibition/form";
    }
}
