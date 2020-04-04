package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import pro3.attandance.utils.PermissionUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ucastnici")
public class AttendeesListController {

    @GetMapping
    public RedirectView attendees(HttpServletRequest request) {
        if(PermissionUtils.isAllowed(request, "attendees", "user")) {
            return new RedirectView("/ucastnici/attendeeList");
        }
        return new RedirectView("/");
    }

    @GetMapping("/attendeeList")
    private String atendeeList () {
        return "attendees/index";
    }

}
