package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pro3.attandance.model.Attendee;
import pro3.attandance.model.User;
import pro3.attandance.model.UserAction;
import pro3.attandance.services.*;
import pro3.attandance.utils.PermissionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class ProfileController {

    private UserService userService;

    private AttendeeService attendeeService;

    private UserActionService userActionService;

    private TrainingService trainingService;

    private AttendanceService attendanceService;

    public ProfileController(UserService userService, AttendeeService attendeeService, UserActionService userActionService, TrainingService trainingService, AttendanceService attendanceService) {
        this.userService = userService;
        this.attendeeService = attendeeService;
        this.userActionService = userActionService;
        this.trainingService = trainingService;
        this.attendanceService = attendanceService;
    }

    @GetMapping("/profil/user/{id}")
    public String userProfile(@PathVariable("id") int id, Model model) {
        Optional<User> userOpt = userService.getById(id);
        User user;
        user = userOpt.orElse(null);
        model.addAttribute("personid", id);
        model.addAttribute("user", user);
        model.addAttribute("userActions", userActionService.getUsersAction(id));
        return "users/detail";
    }

    @GetMapping("/profil/attendee/{id}")
    public String attendeeProfile(@PathVariable("id") int id, Model model) {
        Optional<Attendee> attendeeOpt = attendeeService.getById(id);
        Attendee attendee;
        attendee = attendeeOpt.orElse(null);
        model.addAttribute("personid", id);
        model.addAttribute("attendee", attendee);
        model.addAttribute("attendeeTrainings", attendanceService.getTrainingIDs(id));
        return "attendees/detail";
    }

    @GetMapping("/edit")
    public String editForm(HttpServletRequest request, Model model){
        if(PermissionUtils.isPerson(request, "attendee")){
            Attendee attendee = attendeeService.getById(Integer.parseInt(PermissionUtils.id)).orElse(null);
            model.addAttribute("attendee", attendee);
            return "attendees/edit";
        } else if (PermissionUtils.isPerson(request, "user")){
            User user = userService.getById(Integer.parseInt(PermissionUtils.id)).orElse(null);
            model.addAttribute("user", user);
            return "users/edit";
        }
        return "home/index";
    }
}
