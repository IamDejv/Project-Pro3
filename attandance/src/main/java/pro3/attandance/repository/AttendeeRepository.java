package pro3.attandance.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro3.attandance.model.Attendee;

@Repository
public interface AttendeeRepository extends CrudRepository<Attendee, Integer> {

    Attendee findAttendeeByPerson_Personid(int id);
}
