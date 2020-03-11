package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pro3.attandance.model.FormData;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class RegistrationController {

    @GetMapping("/registrace")
    public String registration() {
        return "registration/index";
    }

    @PostMapping(path = "/registrate", consumes = "application/json")
    public String registrate(@RequestBody FormData data) {
        System.out.println(data.toString());
        return "registration/index";
    }
}
