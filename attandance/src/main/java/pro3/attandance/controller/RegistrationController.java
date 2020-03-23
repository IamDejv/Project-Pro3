package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pro3.attandance.model.FormData;

@Controller
@RequestMapping("/registrace")
public class RegistrationController {

    @GetMapping
    public String registration() {
        return "registration/index";
    }

    @PostMapping(path = "/registrate", consumes = "application/json")
    public void registrate(@RequestBody FormData data) {
        System.out.println(data.toString());

    }
}
