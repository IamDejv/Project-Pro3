package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import pro3.attandance.utils.FlashMessageUtil;
import pro3.attandance.utils.PermissionUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/uzivatele")
public class UsersListController {

    @GetMapping
    public RedirectView uzivatele(HttpServletRequest request) {
        if(PermissionUtils.isAllowed(request, "users", "user")) {
            return new RedirectView("/uzivatele/users");
        } else {
            FlashMessageUtil.message = "Nemáte dostatečná oprávnění";
            FlashMessageUtil.messageType = 2;
        }
        return new RedirectView("/");
    }

    @GetMapping("/users")
    private String users(Model model) {
        if ( FlashMessageUtil.message != null) {
            model.addAttribute("message", FlashMessageUtil.message);
            model.addAttribute("messageType", FlashMessageUtil.messageType);
            FlashMessageUtil.message = null;
        }
        return "users/index";
    }
}
