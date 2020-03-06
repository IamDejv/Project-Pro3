package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.Company;
import pro3.attandance.model.ContactInfo;
import pro3.attandance.repository.ContactInfoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContactInfoService {

    private final ContactInfoRepository contactInfoRepository;

    public ContactInfoService(ContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    public List<ContactInfo> getUser() {
        return (List<ContactInfo>) contactInfoRepository.findAll();
    }

    public Optional<ContactInfo> getUserById(int id) {
        return contactInfoRepository.findById(id);
    }

    public void addUser(ContactInfo contactInfo) {
        contactInfoRepository.save(contactInfo);
    }

    public void deleteUser(int id) {
        contactInfoRepository.deleteById(id);
    }

    public void updateUser(int id, Company company) {

    }

}
