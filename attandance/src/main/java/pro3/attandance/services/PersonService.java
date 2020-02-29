package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.Person;
import pro3.attandance.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getUser() {
        return (List<Person>) personRepository.findAll();
    }

    public Optional<Person> getUserById(int id) {
        return personRepository.findById(id);
    }

    public void addUser(Person person) {
        personRepository.save(person);
    }

    public void deleteUser(int id) {
        personRepository.deleteById(id);
    }

    public void updateUser(int id, Person person) {

    }
}