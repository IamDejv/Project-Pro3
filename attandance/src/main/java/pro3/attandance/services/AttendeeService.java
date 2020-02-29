package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.Attendee;
import pro3.attandance.repository.AttendeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AttendeeService {

    private final AttendeeRepository attendeeRepository;

    public AttendeeService(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    public List<Attendee> getUser() {
        return (List<Attendee>) attendeeRepository.findAll();
    }

    public Optional<Attendee> getUserById(int id) {
        return attendeeRepository.findById(id);
    }

    public void addUser(Attendee attendee) {
        attendeeRepository.save(attendee);
    }

    public void deleteUser(int id) {
        attendeeRepository.deleteById(id);
    }

    public void updateUser(int id, Attendee attendee) {

    }

}
