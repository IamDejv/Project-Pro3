package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pro3.attandance.model.FormData;
import pro3.attandance.services.PersonService;
import pro3.attandance.services.UserService;

@Controller
@RequestMapping("/registrace")
public class RegistrationController {

    private UserService userService;

    private PersonService personService;

    public RegistrationController(UserService userService, PersonService personService) {
        this.userService = userService;
        this.personService = personService;
    }

    @GetMapping
    public String registration(Model model) {
        model.addAttribute("usernames", userService.getAllUsernames());
        model.addAttribute("emails", personService.getAllEmails());
        return "registration/index";
    }

}
