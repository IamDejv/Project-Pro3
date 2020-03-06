package pro3.attandance.services;


import org.springframework.stereotype.Service;
import pro3.attandance.model.Attendance;
import pro3.attandance.repository.AttendanceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> getUser() {
        return (List<Attendance>) attendanceRepository.findAll();
    }

    public Optional<Attendance> getUserById(int id) {
        return attendanceRepository.findById(id);
    }

    public void addUser(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    public void deleteUser(int id) {
        attendanceRepository.deleteById(id);
    }

    public void updateUser(int id, Attendance attendance) {

    }


}
