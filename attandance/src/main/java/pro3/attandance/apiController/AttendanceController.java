package pro3.attandance.apiController;

import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.AssignData;
import pro3.attandance.model.Attendance;
import pro3.attandance.model.Training;
import pro3.attandance.services.AttendanceService;
import pro3.attandance.services.TrainingService;
import pro3.attandance.utils.DayGenerator;
import pro3.attandance.utils.PermissionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    private final TrainingService trainingService;

    public AttendanceController(AttendanceService attendanceService, TrainingService trainingService) {
        this.attendanceService = attendanceService;
        this.trainingService = trainingService;
    }

    @GetMapping
    public List<Attendance> get() {
        return attendanceService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Attendance> getById(@PathVariable("id") Integer id) {
        return attendanceService.getById(id);
    }

    @PostMapping("/assignAttendee")
    public void assignAttendee(@RequestBody Attendance attendance) {
        Training training = trainingService.getById(attendance.getTrainingid()).orElse(null);
        List<String> dates = DayGenerator.generateDates(training.getStartDate(), training.getEndDate());
        for (String date : dates) {
            attendanceService.add(new Attendance(date, attendance.getAttendeeid(), attendance.getTrainingid(),0));
        }
    }


    @PostMapping(produces = "application/json")
    public Attendance add(@RequestBody Attendance attendance) {
        attendanceService.add(attendance);
        return attendance;
    }

    @PutMapping("/{id}")
    public Attendance update(@PathVariable("id") int id, @RequestBody String presence) {
        Attendance attendance = attendanceService.getById(id).orElse(null);
        attendance.setPresence(Integer.parseInt(presence));
        attendanceService.update(attendance.getAttendanceid(), attendance);
        return attendance;
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
