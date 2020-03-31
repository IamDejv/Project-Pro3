package pro3.attandance.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro3.attandance.model.ContactInfo;

import java.util.List;

@Repository
public interface ContactInfoRepository extends CrudRepository<ContactInfo, Integer> {
}
