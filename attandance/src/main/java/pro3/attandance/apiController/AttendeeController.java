package pro3.attandance.apiController;

import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.Attendee;
import pro3.attandance.services.AttendeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/attendee")
public class AttendeeController {

    private final AttendeeService attendeeService;

    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @GetMapping
    public List<Attendee> getUser() {
        return attendeeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Attendee> getUserById(@PathVariable("id") Integer id) {
        return attendeeService.getById(id);
    }

    @PostMapping(produces = "application/json")
    public void addUser(@RequestBody Attendee attendee) {
        attendeeService.add(attendee);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        attendeeService.deleteById(id);
    }

    @PutMapping(produces = "application/json")
    public void updateUser(@RequestBody Attendee attendee) {
        attendeeService.update(attendee.getAttendeeid(), attendee);
    }
}
