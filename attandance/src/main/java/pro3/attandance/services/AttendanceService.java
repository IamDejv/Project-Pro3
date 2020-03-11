package pro3.attandance.services;


import org.springframework.stereotype.Service;
import pro3.attandance.model.Attendance;
import pro3.attandance.repository.AttendanceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService implements BaseService<Attendance> {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> getAll() {
        return (List<Attendance>) attendanceRepository.findAll();
    }

    public Optional<Attendance> getById(int id) {
        return attendanceRepository.findById(id);
    }

    public Attendance add(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public void deleteById(int id) {
        attendanceRepository.deleteById(id);
    }

    public Attendance update(int id, Attendance attendance) {
        return attendanceRepository.save(attendance);
    }


}
