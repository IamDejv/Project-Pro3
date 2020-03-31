package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.Attendee;
import pro3.attandance.repository.AttendeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AttendeeService implements BaseService<Attendee> {

    private final AttendeeRepository attendeeRepository;

    public AttendeeService(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public List<Attendee> getAll() {
        return (List<Attendee>) attendeeRepository.findAll();
    }

    @Override
    public Optional<Attendee> getById(int id) {
        return attendeeRepository.findById(id);
    }

    @Override
    public Attendee add(Attendee attendee) {
        return attendeeRepository.save(attendee);
    }

    @Override
    public void deleteById(int id) {
        attendeeRepository.deleteById(id);
    }

    @Override
    public Attendee update(int id, Attendee attendee) {
        return attendeeRepository.save(attendee);
    }

    public Attendee getByPersonId(int id) {
        return attendeeRepository.findAttendeeByPerson_Personid(id);
    }
}
