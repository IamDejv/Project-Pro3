package cz.uhk.fim.pro3.attendence;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendenceController {

    @RequestMapping("/dochazka")
    public String attendence(){
        return "Dochazka";
    }
}
