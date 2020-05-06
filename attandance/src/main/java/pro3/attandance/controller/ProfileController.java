package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;
import pro3.attandance.model.Attendee;
import pro3.attandance.model.Person;
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

    private PersonService personService;

    private AttendanceService attendanceService;

    private String message;

    public ProfileController(UserService userService, AttendeeService attendeeService, UserActionService userActionService, TrainingService trainingService, AttendanceService attendanceService, PersonService personService) {
        this.userService = userService;
        this.attendeeService = attendeeService;
        this.userActionService = userActionService;
        this.trainingService = trainingService;
        this.attendanceService = attendanceService;
        this.personService = personService;
    }

    @GetMapping("/profil/user/{id}")
    public String userProfile(@PathVariable("id") int id, Model model) {
        Optional<User> userOpt = userService.getById(id);
        User user;
        user = userOpt.orElse(null);
        model.addAttribute("personid", id);
        model.addAttribute("user", user);
        model.addAttribute("userActions", userActionService.getUsersAction(id));
        if(message != null && !message.equals("")) {
            model.addAttribute("message", message);
            message = null;
        }
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
        if(message != null && !message.equals("")) {
            model.addAttribute("message", message);
            message = null;
        }
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

    @GetMapping("/activate/{id}")
    public RedirectView activateUser(@PathVariable("id") int id, HttpServletRequest request) {
        try {
            if(PermissionUtils.isAllowed(request, "activate", "user")) {
                Person person = personService.getById(id).orElse(null);
                person.setActive(true);
                personService.update(id, person);
            }
            User user = userService.getUserByPersonId(id);
            message = "Uživatel byl aktivován";
            if(user != null) {
                return new RedirectView("/profil/user/" + user.getUserid());
            } else {
                Attendee attendee = attendeeService.getByPersonId(id);
                return new RedirectView("/profil/attendee/" + attendee.getAttendeeid());
            }
        } catch (Exception e) {
            message = e.getMessage();
            return new RedirectView("/");
        }
    }

    @GetMapping("/deactivate/{id}")
    public RedirectView deactivateUser(@PathVariable("id") int id, HttpServletRequest request) {
        try {
            if(PermissionUtils.isAllowed(request, "deactivate", "user")) {
                Person person = personService.getById(id).orElse(null);
                person.setActive(false);
                personService.update(id, person);
            }
            User user = userService.getUserByPersonId(id);
            message = "Uživatel byl deaktivován";
            if(user != null) {
                return new RedirectView("/profil/user/" + user.getUserid());
            } else {
                Attendee attendee = attendeeService.getByPersonId(id);
                return new RedirectView("/profil/attendee/" + attendee.getAttendeeid());
            }
        } catch (Exception e) {
            message = e.getMessage();
            return new RedirectView("/");
        }
    }

    @GetMapping("/promote/{id}")
    public RedirectView promoteUser(@PathVariable("id") int id, HttpServletRequest request) {
        try {
            if(PermissionUtils.isAllowed(request, "promote", "user")) {
                User user = userService.getById(id).orElse(null);
                user.getPerson().setRoleid(3);
                userService.update(id, user);
            }
        } catch (Exception e){
            message = e.getMessage();
        }
        return new RedirectView("/profil/user/" + id);
    }
}
