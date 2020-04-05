package pro3.attandance.apiController;

import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.Attendance;
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

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") int id, @RequestBody Attendee attendee) {
        Attendee oldAttendee = getUserById(id).orElse(null);
        oldAttendee.setPaid(attendee.isPaid());
        oldAttendee.setPerson(attendee.getPerson());
        attendeeService.update(attendee.getAttendeeid(), oldAttendee);
    }

    @PutMapping("/pay/{id}")
    public void pay(@PathVariable("id") int id, @RequestBody int paid) {
        Attendee attendee = attendeeService.getById(id).orElse(null);
        attendee.setPaid(paid == 0);
        attendeeService.update(id, attendee);
    }
}
