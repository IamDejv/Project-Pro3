package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import pro3.attandance.utils.FlashMessageUtil;
import pro3.attandance.utils.PermissionUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ucastnici")
public class AttendeesListController {

    @GetMapping
    public RedirectView attendees(HttpServletRequest request, Model model) {
        if(PermissionUtils.isAllowed(request, "attendees", "user")) {
            return new RedirectView("/ucastnici/attendeeList");
        } else {
            FlashMessageUtil.message = "Nemáte dostatečná oprávnění";
            FlashMessageUtil.messageType = 2;
        }
        if(FlashMessageUtil.message != null) {
            model.addAttribute("message", FlashMessageUtil.message);
            model.addAttribute("messageType", FlashMessageUtil.messageType);
            FlashMessageUtil.message = null;
        }
        return new RedirectView("/");
    }

    @GetMapping("/attendeeList")
    private String atendeeList (Model model) {
        if(FlashMessageUtil.message != null) {
            model.addAttribute("message", FlashMessageUtil.message);
            model.addAttribute("messageType", FlashMessageUtil.messageType);
        }
        return "attendees/index";
    }

}
