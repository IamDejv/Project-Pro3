package pro3.attandance.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pro3.attandance.model.FormData;

import javax.servlet.http.HttpServletRequest;
import java.text.Normalizer;

@Controller
public class RegistrationController {

    @GetMapping("/registrace")
    public String registration(){
        return "registration/index";
    }

    @PostMapping(path = "/registrate", consumes = "application/json")
    public String registrate(@RequestBody FormData data) {
        System.out.println(data.getFistname());
        return "registration/index";
    }
}
