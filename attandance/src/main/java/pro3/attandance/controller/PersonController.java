package pro3.attandance.controller;

import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.Person;
import pro3.attandance.model.Training;
import pro3.attandance.model.User;
import pro3.attandance.services.PersonService;
import pro3.attandance.services.TrainingService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getUser() {
        return personService.getUser();
    }

    @GetMapping("/{id}")
    public Optional<Person> getUserById(@PathVariable("id") Integer id) {
        return personService.getUserById(id);
    }

    @PostMapping(produces = "application/json")
    public void addUser(@RequestBody Person person) {
        personService.addUser(person);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable ("id") Integer id){
        personService.deleteUser(id);
    }

    @PutMapping(produces = "application/json")
    public void updateUser(@RequestBody Person person){
        personService.updateUser(person.getPersonid(), person);
    }
}
