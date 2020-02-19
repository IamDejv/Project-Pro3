package cz.uhk.fim.pro3.attendence.dao;

import cz.uhk.fim.pro3.attendence.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
