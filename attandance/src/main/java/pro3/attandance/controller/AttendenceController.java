package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dochazka")
@Controller
public class AttendenceController {

    @GetMapping
    public String attendence(){
        return "attendance";
    }
}
