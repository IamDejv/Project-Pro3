package pro3.attandance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro3.attandance.model.Person;
import pro3.attandance.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements BaseService<Person> {

    @Autowired
    private AddressService addressService;

    @Autowired
    private ContactInfoService contactInfoService;

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Optional<Person> getById(int id) {
        return personRepository.findById(id);
    }

    @Override
    public Person add(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deleteById(int id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person update(int id, Person person) {
        person.setPersonid(id);
        person.setAddress(addressService.update(person.getAddress().getAddresid(), person.getAddress()));
        person.setContactInfo(contactInfoService.update(person.getContactInfo().getContactinfoid(), person.getContactInfo()));
        return personRepository.save(person);
    }

    public List<Person> getByRoleid(int id) {
        return personRepository.findPersonByRoleid(id);
    }

    public Person getPersonByEmail(String email) {
        return personRepository.findPersonByContactInfo_Email(email);
    }

    public List<String> getAllEmails() {
        List<String> emails = new ArrayList<>();
        for (Person person : getAll()) {
            emails.add(person.getContactInfo().getEmail());
        }
        return emails;
    }
}
