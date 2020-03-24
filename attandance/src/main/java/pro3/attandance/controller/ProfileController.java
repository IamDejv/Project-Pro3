package pro3.attandance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pro3.attandance.model.User;
import pro3.attandance.services.UserService;

import java.util.Optional;

@Controller
public class ProfileController {

    private UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profil/{id}")
    public String profile(@PathVariable("id") int id, Model model) {

        Optional<User> userOpt = userService.getById(id);
        User user;
        user = userOpt.orElse(null);
        model.addAttribute("personid", id);
        model.addAttribute("user", user);
        System.out.println(user.getUsername());
        return "profile/index";
    }
}
