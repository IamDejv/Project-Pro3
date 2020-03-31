package pro3.attandance.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro3.attandance.model.Person;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findPersonByRoleid(int id);

    Person findPersonByContactInfo_Email(String email);
}
