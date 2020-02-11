package cz.uhk.fim.pro3.attendence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttendenceController {

    @GetMapping("/dochazka")
    public String attendence(){
        return "attendance";
    }
}
