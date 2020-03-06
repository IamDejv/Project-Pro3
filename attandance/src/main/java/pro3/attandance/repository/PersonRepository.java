package pro3.attandance.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro3.attandance.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
