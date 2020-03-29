package pro3.attandance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pro3.attandance.model.Attendee;
import pro3.attandance.model.User;
import pro3.attandance.services.AttendeeService;
import pro3.attandance.services.UserService;

import java.util.Optional;

@Controller
public class ProfileController {

    private UserService userService;

    private AttendeeService attendeeService;

    public ProfileController(UserService userService, AttendeeService attendeeService) {
        this.userService = userService;
        this.attendeeService = attendeeService;
    }

    @GetMapping("/profil/user/{id}")
    public String userProfile(@PathVariable("id") int id, Model model) {

        Optional<User> userOpt = userService.getById(id);
        User user;
        user = userOpt.orElse(null);
        model.addAttribute("personid", id);
        model.addAttribute("user", user);
        System.out.println(user.getUsername());
        return "profile/index";
    }

    @GetMapping("/profil/attendee/{id}")
    public String attendeeProfile(@PathVariable("id") int id, Model model) {

        Optional<Attendee> attendeeOpt = attendeeService.getById(id);
        Attendee attendee;
        attendee = attendeeOpt.orElse(null);
        model.addAttribute("personid", id);
        model.addAttribute("attendee", attendee);
        return "profile/index";
    }
}
