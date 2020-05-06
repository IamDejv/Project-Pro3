package pro3.attandance.apiController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pro3.attandance.model.Attendance;
import pro3.attandance.model.Attendee;
import pro3.attandance.services.AttendeeService;
import pro3.attandance.services.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/attendee")
public class AttendeeController {

    private final AttendeeService attendeeService;

    private final PersonService personService;

    public AttendeeController(AttendeeService attendeeService, PersonService personService) {
        this.attendeeService = attendeeService;
        this.personService = personService;
    }

    @GetMapping
    public List<Attendee> get() {
        return attendeeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Attendee> getById(@PathVariable("id") Integer id) {
        return attendeeService.getById(id);
    }

    @PostMapping(produces = "application/json")
    public Attendee add(@RequestBody Attendee attendee) {
        try{
            if(personService.getPersonByEmail(attendee.getPerson().getContactInfo().getEmail()) == null) {
                attendeeService.add(attendee);
            } else {
                throw new Exception("Email byl použit jiným uživatelem");
            }
            return attendee;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage(), e);
        }

    }

    @PutMapping("/{id}")
    public Attendee update(@PathVariable("id") int id, @RequestBody Attendee attendee) {
        Attendee oldAttendee = getById(id).orElse(null);
        if(oldAttendee != null) {
            oldAttendee.setPaid(attendee.isPaid());
            oldAttendee.setPerson(attendee.getPerson());
            attendeeService.update(attendee.getAttendeeid(), oldAttendee);
        }
        return attendee;
    }

    @PutMapping("/pay/{id}")
    public void pay(@PathVariable("id") int id, @RequestBody int paid) {
        Attendee attendee = attendeeService.getById(id).orElse(null);
        if(attendee != null) {
            attendee.setPaid(paid == 0);
            attendeeService.update(id, attendee);
        }
    }
}
