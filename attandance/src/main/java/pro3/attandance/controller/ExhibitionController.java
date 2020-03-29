package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pro3.attandance.model.Action;
import pro3.attandance.model.UserAction;
import pro3.attandance.services.ActionService;
import pro3.attandance.services.UserActionService;

import java.util.List;
import java.util.Optional;

@Controller
public class ExhibitionController {

    private ActionService actionService;

    private UserActionService userActionService;

    public ExhibitionController (ActionService actionService, UserActionService userActionService) {
        this.actionService = actionService;
        this.userActionService = userActionService;
    }

    @GetMapping("/vystoupeni")
    public String exhibition(){
        return "exhibition/index";
    }

    @GetMapping("/action/{id}")
    public String actionInfo(@PathVariable("id") int id, Model model) {

        Optional<Action> actionOpt = actionService.getById(id);
        List<UserAction> users = userActionService.getByActionId(id);
        Action action;
        action = actionOpt.orElse(null);
        model.addAttribute("actionid", id);
        model.addAttribute("action", action);
        model.addAttribute("users", users);
        return "profile/index";
    }
}
