package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import pro3.attandance.model.Attendee;
import pro3.attandance.model.LoginData;
import pro3.attandance.model.Person;
import pro3.attandance.model.User;
import pro3.attandance.services.AttendeeService;
import pro3.attandance.services.PersonService;
import pro3.attandance.services.UserService;
import pro3.attandance.utils.FlashMessageUtil;
import pro3.attandance.utils.PermissionUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class HomeController {


    private UserService userService;

    private AttendeeService attendeeService;

    private PersonService personService;

    public HomeController(UserService userService, AttendeeService attendeeService, PersonService personService) {
        this.userService = userService;
        this.attendeeService = attendeeService;
        this.personService = personService;
    }

    @GetMapping("/home")
    private String home(Model model){
        if(FlashMessageUtil.message != null) {
            model.addAttribute("message", FlashMessageUtil.message);
            model.addAttribute("messageType", FlashMessageUtil.messageType);
            FlashMessageUtil.message = null;
        }
        return "home/index";
    }

    @GetMapping("/")
    public RedirectView index(HttpServletRequest request, Model model) {
        if(PermissionUtils.isPerson(request, "user")){
            Optional<User> userOpt = userService.getById(Integer.parseInt(PermissionUtils.id));
            User user = userOpt.orElse(null);
            if (user != null) {
                model.addAttribute("personid", user.getPerson().getPersonid());
                model.addAttribute("user", user);
                return new RedirectView("/profil/user/" + user.getUserid());
            }
        } else if (PermissionUtils.isPerson(request, "attendee")) {
            Optional<Attendee> attendeeOpt = attendeeService.getById(Integer.parseInt(PermissionUtils.id));
            Attendee attendee = attendeeOpt.orElse(null);
            if (attendee != null) {
                model.addAttribute("personid", attendee.getPerson().getPersonid());
                model.addAttribute("attendee", attendee);
                return new RedirectView("/profil/attendee/" + attendee.getAttendeeid());
            }
        }
        return new RedirectView("/home");
    }

    @PostMapping("/login")
    public RedirectView login(LoginData data, Model model, HttpServletResponse response) {
        if (!data.getRole()) {
            User user = userService.getByUsername(data.getUsername());
            if (user == null) {
                FlashMessageUtil.message = "Špatné uživatelské jméno";
                FlashMessageUtil.messageType = 2;
                return new RedirectView("/");
            } else {
                if (user.getPerson().getPassword().equals(data.getPassword())) {
                    response.addCookie(new Cookie("user", "" + user.getUserid()));
                    response.addCookie(new Cookie("role", "" + user.getPerson().getRoleid()));
                    model.addAttribute("personid", user.getPerson().getPersonid());
                    model.addAttribute("user", user);
                    FlashMessageUtil.message = "Přihlášení proběhlo úspěšně";
                    FlashMessageUtil.messageType = 0;
                    return new RedirectView("/profil/user/" + user.getUserid());
                } else {
                    FlashMessageUtil.message = "Špatné heslo";
                    FlashMessageUtil.messageType = 2;
                }
            }
        } else {
            Person person = personService.getPersonByEmail(data.getUsername());
            if (person == null) {
                FlashMessageUtil.message = "Špatný email";
                FlashMessageUtil.messageType = 2;
                return new RedirectView("/");
            } else {
                Attendee attendee = attendeeService.getByPersonId(person.getPersonid());
                if (attendee == null) {
                    FlashMessageUtil.message = "Špatný email";
                    FlashMessageUtil.messageType = 2;
                    return new RedirectView("/");
                } else {
                    if (person.getPassword().equals(data.getPassword())) {
                        response.addCookie(new Cookie("attendee", "" + attendee.getAttendeeid()));
                        response.addCookie(new Cookie("role", "" + person.getRoleid()));
                        model.addAttribute("personid", person.getPersonid());
                        model.addAttribute("attendee", attendee);
                        FlashMessageUtil.message = "Přihlášení proběhlo úspěšně";
                        FlashMessageUtil.messageType = 0;
                        return new RedirectView("/profil/attendee/" + attendee.getAttendeeid());
                    } else {
                        FlashMessageUtil.message = "Špatné heslo";
                        FlashMessageUtil.messageType = 2;
                    }
                }
            }
        }
        return new RedirectView("/");
    }

    @GetMapping("/logout")
    public RedirectView logout(Model model, HttpServletResponse response) {
        Cookie cookieUser = new Cookie("user", null);
        Cookie cookieRole = new Cookie("role", null);
        Cookie cookieAttendee = new Cookie("attendee", null);
        cookieUser.setMaxAge(0);
        cookieRole.setMaxAge(0);
        cookieAttendee.setMaxAge(0);
        response.addCookie(cookieUser);
        response.addCookie(cookieRole);
        response.addCookie(cookieAttendee);
        FlashMessageUtil.message = "Odhlášení proběhlo úspěšně";
        FlashMessageUtil.messageType = 1;
        return new RedirectView("/");
    }

}
