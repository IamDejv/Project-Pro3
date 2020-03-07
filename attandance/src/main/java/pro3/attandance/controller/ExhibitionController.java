package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExhibitionController {

    @GetMapping("/vystoupeni")
    public String exhibition(){
        return "exhibition/index";
    }
}
