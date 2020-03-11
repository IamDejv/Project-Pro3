package pro3.attandance.services;

import org.springframework.stereotype.Service;
import pro3.attandance.model.ContactInfo;
import pro3.attandance.repository.ContactInfoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContactInfoService implements BaseService<ContactInfo> {

    private final ContactInfoRepository contactInfoRepository;

    public ContactInfoService(ContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    @Override
    public List<ContactInfo> getAll() {
        return (List<ContactInfo>) contactInfoRepository.findAll();
    }

    @Override
    public Optional<ContactInfo> getById(int id) {
        return contactInfoRepository.findById(id);
    }

    @Override
    public ContactInfo add(ContactInfo contactInfo) {
        return contactInfoRepository.save(contactInfo);
    }

    @Override
    public void deleteById(int id) {
        contactInfoRepository.deleteById(id);
    }

    @Override
    public ContactInfo update(int id, ContactInfo contactInfo) {
        return contactInfoRepository.save(contactInfo);
    }
}
