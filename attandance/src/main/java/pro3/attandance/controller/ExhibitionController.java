package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;
import pro3.attandance.model.Action;
import pro3.attandance.model.User;
import pro3.attandance.model.UserAction;
import pro3.attandance.services.ActionService;
import pro3.attandance.services.UserActionService;
import pro3.attandance.services.UserService;
import pro3.attandance.utils.FlashMessageUtil;
import pro3.attandance.utils.PermissionUtils;

import javax.servlet.http.HttpServletRequest;
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
    public RedirectView exhibition(HttpServletRequest request){
        if (PermissionUtils.isAllowed(request, "action", "user")) {
            return new RedirectView("/actions");
        } else {
            FlashMessageUtil.message = "Nemáte dostatečná oprávnění";
            FlashMessageUtil.messageType = 2;
        }
        return new RedirectView("/");
    }

    @GetMapping("/actions")
    private String actionList(Model model) {
        if(FlashMessageUtil.message != null) {
            model.addAttribute("message", FlashMessageUtil.message);
            model.addAttribute("messageType", FlashMessageUtil.messageType);
            FlashMessageUtil.message = null;
        }
        return "exhibition/index";
    }

    @GetMapping("/action/{id}")
    public String actionDetail(@PathVariable("id") int id, Model model, HttpServletRequest request) {
        String url = "exhibition/index";
        if (PermissionUtils.isAllowed(request, "action", "user")) {
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
            url = "exhibition/detail";
        } else {
            FlashMessageUtil.message = "Nemáte dostatečná oprávnění";
            FlashMessageUtil.messageType = 2;
        }
        if(FlashMessageUtil.message != null) {
            model.addAttribute("message", FlashMessageUtil.message);
            model.addAttribute("messageType", FlashMessageUtil.messageType);
            FlashMessageUtil.message = null;
        }
        return url;
    }

    @GetMapping("/vystoupeni/add")
    public String actionForm(HttpServletRequest request, Model model) {
        String url = "home/index";
        if(PermissionUtils.isAllowed(request, "addAction", "user")) {
            url = "exhibition/form";
        } else {
            FlashMessageUtil.message = "Nemáte dostatečná oprávnění";
            FlashMessageUtil.messageType = 2;
        }
        if(FlashMessageUtil.message != null) {
            model.addAttribute("message", FlashMessageUtil.message);
            model.addAttribute("messageType", FlashMessageUtil.messageType);
            FlashMessageUtil.message = null;
        }
        return url;
    }

    @GetMapping("/action/delete/{id}")
    public RedirectView deleteAction(@PathVariable("id") int actionId, HttpServletRequest request) {
        if(PermissionUtils.isAllowed(request, "manageAction", "user")) {
            userActionService.deleteAllByActionId(actionId);
            actionService.deleteById(actionId);
            FlashMessageUtil.message = "Akce byla úspešně smazána";
            FlashMessageUtil.messageType = 0;
        } else {
            FlashMessageUtil.message = "Nemáte dostatečná oprávnění";
            FlashMessageUtil.messageType = 2;
        }
        return new RedirectView("/vystoupeni");

    }

    @GetMapping("/exhibition/deleteUser/{userid}/{actionid}")
    public RedirectView deleleteUserAction(@PathVariable("userid") int userId, @PathVariable("actionid") int actionId, HttpServletRequest request) {
        if (PermissionUtils.isAllowed(request, "manageAction", "user")) {
            userActionService.deleteByUserIdAndActionId(userId, actionId);
            FlashMessageUtil.message = "Uživatel byl úspešně odebrán z akce";
            FlashMessageUtil.messageType = 0;
            return new RedirectView("/action/" + actionId);
        } else {
            FlashMessageUtil.message = "Nemáte dostatečná oprávnění";
            FlashMessageUtil.messageType = 2;
        }
        return new RedirectView("/vystoupeni");
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") int id, HttpServletRequest request, Model model){
        String url = "exhibition/index";
        Action action = actionService.getById(id).orElse(null);
        if(PermissionUtils.isAllowed(request, "editAction", "user")){
            model.addAttribute("action", action);
            url = "exhibition/edit";
        } else if (PermissionUtils.isPerson(request, "user")) {
            if (userActionService.getUsersAction(Integer.parseInt(PermissionUtils.id)).contains(id)){
                model.addAttribute("action", action);
                url = "exhibition/edit";
            }
        } else {
            FlashMessageUtil.message = "Nemáte dostatečná oprávnění";
            FlashMessageUtil.messageType = 2;
        }
        return url;
    }

    @PostMapping("/vystoupeni/addUser/{id}")
    public RedirectView addUserToAction(@PathVariable("id") int id, @RequestBody int userId, HttpServletRequest request, Model model) {
        if(PermissionUtils.isAllowed(request, "addUserToAction", "user")) {
            UserAction userAction = new UserAction();
            userAction.setActionid(id);
            userAction.setUserid(userId);
            userActionService.add(userAction);
            FlashMessageUtil.message = "Uživatel byl úspěšně přidán";
            FlashMessageUtil.messageType = 0;
        } else {
            FlashMessageUtil.message = "Nemáte dostatečně oprávnění";
            FlashMessageUtil.messageType = 2;
        }
        model.addAttribute("message", FlashMessageUtil.message);
        model.addAttribute("messageType", FlashMessageUtil.messageType);
        return new RedirectView("action/" + id);

    }
}
