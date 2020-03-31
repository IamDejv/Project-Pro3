package pro3.attandance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pro3.attandance.model.Person;
import pro3.attandance.model.Training;
import pro3.attandance.model.User;
import pro3.attandance.services.PersonService;
import pro3.attandance.services.TrainingService;
import pro3.attandance.services.UserService;

import java.util.*;

@RequestMapping("/dochazka")
@Controller
public class AttendenceController {

    private PersonService personService;

    private UserService userService;

    private TrainingService trainingService;

    public AttendenceController(PersonService personService, UserService userService, TrainingService trainingService) {
        this.personService = personService;
        this.userService = userService;
        this.trainingService = trainingService;
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
        model.addAttribute("training", training);
        return "attendance/detail";
    }
}
