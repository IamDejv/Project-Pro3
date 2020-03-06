package pro3.attandance.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro3.attandance.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
