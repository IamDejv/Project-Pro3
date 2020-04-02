package pro3.attandance.controller;

import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.Person;
import pro3.attandance.services.PersonService;

import java.util.ArrayList;
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
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> getUserById(@PathVariable("id") Integer id) {
        return personService.getById(id);
    }

    @PostMapping(produces = "application/json")
    public void addUser(@RequestBody Person person) {
        personService.add(person);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        personService.deleteById(id);
    }

    @PutMapping(produces = "application/json")
    public void updateUser(@RequestBody Person person) {
        personService.update(person.getPersonid(), person);
    }

}
