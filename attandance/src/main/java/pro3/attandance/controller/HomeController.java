package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pro3.attandance.model.LoginData;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "home/index";
    }

    @PostMapping("/login")
    public ModelAndView login(LoginData data){
        System.out.println(data.getUsername());
        return null;
    }



}
