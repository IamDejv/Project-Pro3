package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import pro3.attandance.model.*;
import pro3.attandance.services.AttendanceService;
import pro3.attandance.services.PersonService;
import pro3.attandance.services.TrainingService;
import pro3.attandance.services.UserService;
import pro3.attandance.utils.DayGenerator;
import pro3.attandance.utils.PermissionUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.*;

@RequestMapping("/dochazka")
@Controller
public class AttendenceController {

    private AttendanceService attendanceService;

    private PersonService personService;

    private UserService userService;

    private TrainingService trainingService;

    public AttendenceController(PersonService personService, UserService userService, TrainingService trainingService, AttendanceService attendanceService) {
        this.personService = personService;
        this.userService = userService;
        this.trainingService = trainingService;
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public String attendance(HttpServletRequest request, Model model){
        if(PermissionUtils.isPerson(request, "attendee")){
            model.addAttribute("availableTrainings", attendanceService.getTrainingIDs(Integer.parseInt(PermissionUtils.id)));
        } else if (PermissionUtils.getRole(request).equals("1")) {
            model.addAttribute("availableTrainings", trainingService.getUsersTraining(Integer.parseInt(PermissionUtils.id)));
        }
        return "attendance/index";
    }

    @GetMapping("/add")
    public RedirectView attendanceForm(HttpServletRequest request) {
        if(PermissionUtils.isAllowed(request, "addTraining", "user")) {
            return new RedirectView("/dochazka/form");
        }
        return new RedirectView("/dochazka");
    }

    @GetMapping("/form")
    private String addTraining(Model model) {
        List<Person> personList = personService.getByRoleid(2);
        Map<Integer, String> userList = new HashMap<>();
        for (Person person: personList) {
            User user = userService.getUserByPersonId(person.getPersonid());
            userList.put(user.getUserid(), person.getFirstname() + " " + person.getLastname());
        }
        model.addAttribute("users", userList);
        return "attendance/form";
    }

    @GetMapping("/{id}")
    public String trainingDetail(@PathVariable(name = "id") int id, Model model, HttpServletRequest request) {
        if (PermissionUtils.isAllowed(request, "training", "user") || PermissionUtils.isAllowed(request, "simpleTraining", "attendee")) {
            Optional<Training> trainingOpt = trainingService.getById(id);
            Training training = trainingOpt.orElse(null);
            boolean assignedOn = attendanceService.IsAssigned(Integer.parseInt(PermissionUtils.id), id);
            if(PermissionUtils.isPerson(request, "attendee")) {
                model.addAttribute("simple", true);
            } else {
                model.addAttribute("simple", false);
            }
            model.addAttribute("training", training);
            model.addAttribute("trainingDates", DayGenerator.generateDates(training.getStartDate(), training.getEndDate()));
            model.addAttribute("assignedOn", assignedOn);
            return "attendance/detail";
        }
        return "attendance/index";
    }

    @PostMapping("/assignAttendee")
    public String assignAttendee(@RequestBody AssignData data, HttpServletRequest request) {
        if(PermissionUtils.isAllowed(request, "application", "attendee")) {
            Training training = trainingService.getById(data.getTrainingid()).orElse(null);
            List<String> dates = DayGenerator.generateDates(training.getStartDate(), training.getEndDate());
            for (String date : dates) {
                attendanceService.add(new Attendance(date, data.getAttendeeid(), data.getTrainingid(),0));
            }
            return "attendance/index";
        }
        return "attendance/index";
    }

    @GetMapping("/excuse")
    public RedirectView excuseUser(HttpServletRequest request){
        if (PermissionUtils.isAllowed(request, "excuse", "attendee")) {
            return new RedirectView("/dochazka/excuseForm");
        }
        return new RedirectView("/");
    }

    @GetMapping("/excuseForm")
    private String excuseForm() {
        return "attendees/excuseForm";
    }
}
