package cz.uhk.fim.pro3.attendence.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profil")
    public String profile() {
        return "profile";
    }
}
