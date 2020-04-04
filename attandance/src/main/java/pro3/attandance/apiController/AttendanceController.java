package pro3.attandance.apiController;

import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.Attendance;
import pro3.attandance.services.AttendanceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public List<Attendance> getUser() {
        return attendanceService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Attendance> getUserById(@PathVariable("id") Integer id) {
        return attendanceService.getById(id);
    }

    @PostMapping(produces = "application/json")
    public void addUser(@RequestBody Attendance attendance) {
        attendanceService.add(attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        attendanceService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") int id, @RequestBody String presence) {
        System.out.println(id);
        System.out.println(presence);
        Attendance attendance = attendanceService.getById(id).orElse(null);
        attendance.setPresence(Integer.parseInt(presence));
        attendanceService.update(attendance.getAttendanceid(), attendance);
    }

    @GetMapping("/training/{id}")
    public List<Attendance> getAllByTrainingId (@PathVariable("id") int id) {
        return attendanceService.getAllByTrainingId(id);
    }

    @GetMapping("/{id}/attendee")
    public List<Attendance> getAllByAttendeeId(@PathVariable("id")int id){
        return attendanceService.getAllByAttendeeId(id);
    }

    @GetMapping("/training/{attendeeId}/{trainingId}")
    public List<Attendance> getAllByAttendeeAndTraining(@PathVariable("attendeeId") int attendeeId, @PathVariable("trainingId") int trainingid) {
        return attendanceService.getAllByAttendeeAndTraining(attendeeId, trainingid);
    }
}
