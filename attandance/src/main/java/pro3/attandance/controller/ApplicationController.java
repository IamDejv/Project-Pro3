package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;
import pro3.attandance.model.Attendee;
import pro3.attandance.services.AttendeeService;
import pro3.attandance.utils.FlashMessageUtil;
import pro3.attandance.utils.PermissionUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ApplicationController {


    private AttendeeService attendeeService;

    public ApplicationController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @GetMapping("/prihlaska")
    public RedirectView prihlaska(HttpServletRequest request, Model model) {
        if (PermissionUtils.isAllowed(request, "application", "attendee")) {
            Attendee attendee = attendeeService.getById(Integer.parseInt(PermissionUtils.id)).orElse(null);
            if(FlashMessageUtil.message != null) {
                model.addAttribute("message", FlashMessageUtil.message);
                model.addAttribute("messageType", FlashMessageUtil.messageType);
                FlashMessageUtil. message = null;
            }
            if(attendee.isPaid()) {
                return new RedirectView("/application");
            }
        } else {
            FlashMessageUtil.message = "Nemáte dostatečná oprávnění";
            FlashMessageUtil.messageType = 2;
        }
        return new RedirectView("/");
    }

    @GetMapping("/application")
    private String application (Model model) {
        if(FlashMessageUtil.message != null) {
            model.addAttribute("message", FlashMessageUtil.message);
            model.addAttribute("messageType", FlashMessageUtil.messageType);
        }
        return "application/index";
    }
}
