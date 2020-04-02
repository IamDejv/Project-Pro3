package pro3.attandance.controller;

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

    @PutMapping(produces = "application/json")
    public void updateUser(@RequestBody Attendance attendance) {
        attendanceService.update(attendance.getAttendanceid(), attendance);
    }
}
