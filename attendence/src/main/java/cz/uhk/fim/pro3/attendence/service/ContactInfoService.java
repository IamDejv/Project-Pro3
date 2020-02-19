package cz.uhk.fim.pro3.attendence.service;

import cz.uhk.fim.pro3.attendence.dao.ContactInfoRepository;
import cz.uhk.fim.pro3.attendence.model.ContactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactInfoService {

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    public Optional<ContactInfo> getContact(int id) {
        return contactInfoRepository.findById(id);
    }

    public void addContactInfo(ContactInfo userInfo){ contactInfoRepository.save(userInfo); }

    public void deleteContactInfo(int id) { contactInfoRepository.deleteById(id);}

    public void updateUser(int id, ContactInfo userInfo) {
        ContactInfo oldContact = getContact(id).get();
        oldContact.setEmail(userInfo.getEmail());
        oldContact.setPhone(userInfo.getPhone());
        contactInfoRepository.save(oldContact);
    }


}
