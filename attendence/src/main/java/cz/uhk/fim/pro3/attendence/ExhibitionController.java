package cz.uhk.fim.pro3.attendence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExhibitionController {

    @GetMapping("/vystoupeni")
    public String exhibition(){
        return "registration";
    }
}
