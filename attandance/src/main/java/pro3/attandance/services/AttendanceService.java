package pro3.attandance.services;


import org.springframework.stereotype.Service;
import pro3.attandance.model.Attendance;
import pro3.attandance.repository.AttendanceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService implements BaseService<Attendance> {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<Attendance> getAll() {
        return (List<Attendance>) attendanceRepository.findAll();
    }

    @Override
    public Optional<Attendance> getById(int id) {
        return attendanceRepository.findById(id);
    }

    @Override
    public Attendance add(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public void deleteById(int id) {
        attendanceRepository.deleteById(id);
    }

    @Override
    public Attendance update(int id, Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAllByTrainingId(int id) {
        return attendanceRepository.getAllByTraining_Trainingid(id);
    }

    public List<Attendance> getAllByAttendeeId(int id) {
        return attendanceRepository.getAllByAttendee_Attendeeid(id);
    }

    public boolean IsAssigned(int attendeeId, int trainingId) {
        return !(attendanceRepository.getAllByAttendee_AttendeeidAndTraining_Trainingid(attendeeId, trainingId).isEmpty());
    }

    public List<Attendance> getAllByAttendeeAndTraining(int attendeeid, int trainingid) {
        return attendanceRepository.getAllByAttendee_AttendeeidAndTraining_Trainingid(attendeeid, trainingid);
    }

    public List<Integer> getTrainingIDs(int attendeeID) {
        List<Integer> trainingIDs = new ArrayList<>();
        List<Attendance> attendances = getAllByAttendeeId(attendeeID);
        for (Attendance attendance: attendances) {
            if(!trainingIDs.contains(attendance.getTrainingid())){
                trainingIDs.add(attendance.getTrainingid());
            }
        }
        return trainingIDs;
    }

}
