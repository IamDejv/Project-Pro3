package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.*;
import pro3.attandance.services.AttendanceService;
import pro3.attandance.services.PersonService;
import pro3.attandance.services.TrainingService;
import pro3.attandance.services.UserService;
import pro3.attandance.utils.DayGenerator;

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
    public String attendence(){
        return "attendance/index";
    }

    @GetMapping("/add")
    public String attendanceForm(Model model) {
        List<Person> personList = personService.getByRoleid(1);
        Map<Integer, String> userList = new HashMap<>();
        for (Person person: personList) {
            User user = userService.getUserByPersonId(person.getPersonid());
            userList.put(user.getUserid(), person.getFirstname() + " " + person.getLastname());
        }
        model.addAttribute("users", userList);
        return "attendance/form";
    }

    @GetMapping("/{id}")
    public String trainingDetail(@PathVariable(name = "id") int id, Model model) {
        Optional<Training> trainingOpt = trainingService.getById(id);
        Training training = trainingOpt.orElse(null);
        model.addAttribute("simple", false);
        model.addAttribute("training", training);
        return "attendance/detail";
    }
    @GetMapping("/simple/{id}")
    public String trainingSimpleDetail(@PathVariable(name = "id") int id, Model model) {
        Optional<Training> trainingOpt = trainingService.getById(id);
        Training training = trainingOpt.orElse(null);
        model.addAttribute("simple", true);
        model.addAttribute("training", training);
        return "attendance/detail";
    }

    @PostMapping("/assignAttendee")
    public String assignAttendee(@RequestBody AssignData data) {
        System.out.println(data.getAttendeeid());
        Training training = trainingService.getById(data.getTrainingid()).orElse(null);
        List<String> dates = DayGenerator.generateDates(training.getStartDate(), training.getEndDate());
        for (String date : dates) {
            attendanceService.add(new Attendance(date, data.getAttendeeid(), data.getTrainingid(),0));
        }
        return "attendance/index";
    }
}
