package pro3.attandance.controller;

import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.Attendee;
import pro3.attandance.model.Sponsor;
import pro3.attandance.model.Training;
import pro3.attandance.services.AttendeeService;
import pro3.attandance.services.SponsorService;
import pro3.attandance.services.TrainingService;

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
        return attendeeService.getUser();
    }

    @GetMapping("/{id}")
    public Optional<Attendee> getUserById(@PathVariable("id") Integer id) {
        return attendeeService.getUserById(id);
    }

    @PostMapping(produces = "application/json")
    public void addUser(@RequestBody Attendee attendee) {
        attendeeService.addUser(attendee);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable ("id") Integer id){
        attendeeService.deleteUser(id);
    }

    @PutMapping(produces = "application/json")
    public void updateUser(@RequestBody Attendee attendee){
        attendeeService.updateUser(attendee.getAttendeeid(), attendee);
    }
}
