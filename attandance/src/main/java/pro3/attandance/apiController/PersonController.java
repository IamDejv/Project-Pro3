package pro3.attandance.apiController;

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
    public List<Person> get() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> getById(@PathVariable("id") Integer id) {
        return personService.getById(id);
    }

    @PostMapping(produces = "application/json")
    public Person add(@RequestBody Person person) {
        personService.add(person);
        return person;
    }

    @PutMapping(produces = "application/json")
    public Person update(@RequestBody Person person) {
        personService.update(person.getPersonid(), person);
        return person;
    }

}
