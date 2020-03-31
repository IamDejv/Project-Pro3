package pro3.attandance.controller;

import org.springframework.cache.annotation.Cacheable;
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

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        if(request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("user")) {
                    Optional<User> userOpt = userService.getById(Integer.parseInt(cookie.getValue()));
                    User user = userOpt.orElse(null);
                    if (user == null) {
                        break;
                    }
                    model.addAttribute("personid", user.getPerson().getPersonid());
                    model.addAttribute("user", user);
                    return "profile/index";
                } else if (cookie.getName().equals("attendee")) {
                    Optional<Attendee> attendeeOpt = attendeeService.getById(Integer.parseInt(cookie.getValue()));
                    Attendee attendee = attendeeOpt.orElse(null);
                    if (attendee == null) {
                        break;
                    }
                    model.addAttribute("personid", attendee.getPerson().getPersonid());
                    model.addAttribute("attendee", attendee);
                    return "attendees/detail";
                }
            }
        }
        return "home/index";
    }

    @PostMapping("/login")
    public String login(LoginData data, Model model, HttpServletResponse response) {
        System.out.println(data.getRole());
        if (!data.getRole()) {
            User user = userService.getByUsername(data.getUsername());
            if (user == null) {
                model.addAttribute("error", "Špatné uživatelské jméno");
                return "home/index";
            } else {
                if (user.getPerson().getPassword().equals(data.getPassword())) {
                    System.out.println("Oh yeah");
                    response.addCookie(new Cookie("user", "" + user.getUserid()));
                    response.addCookie(new Cookie("role", "" + user.getPerson().getRoleid()));
                    model.addAttribute("personid", user.getPerson().getPersonid());
                    model.addAttribute("user", user);
                    return "profile/index";
                } else {
                    model.addAttribute("error", "Špatné heslo");
                }
            }
        } else {
            Person person = personService.getPersonByEmail(data.getUsername());
            if (person == null) {
                model.addAttribute("error", "Špatný email");
                return "home/index";
            } else {
                Attendee attendee = attendeeService.getByPersonId(person.getPersonid());
                if (attendee == null) {
                    model.addAttribute("error", "Špatný email");
                    return "home/index";
                } else {
                    if (person.getPassword().equals(data.getPassword())) {
                        System.out.println("Oh yeah");
                        response.addCookie(new Cookie("attendee", "" + attendee.getAttendeeid()));
                        response.addCookie(new Cookie("role", "" + person.getRoleid()));
                        model.addAttribute("personid", person.getPersonid());
                        model.addAttribute("attendee", attendee);
                        return "attendees/detail";
                    } else {
                        model.addAttribute("error", "Špatné heslo");
                    }
                }
            }
        }

        return "home/index";
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
        System.out.println("logout");
        model.addAttribute("logout", "Odhlášení proběhlo úspěšně");
        return new RedirectView("/");
    }

}
