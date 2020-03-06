package pro3.attandance.services;


import org.springframework.stereotype.Service;
import pro3.attandance.model.Address;
import pro3.attandance.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getUser() {
        return (List<Address>) addressRepository.findAll();
    }

    public Optional<Address> getUserById(int id) {
        return addressRepository.findById(id);
    }

    public void addUser(Address address) {
        addressRepository.save(address);
    }

    public void deleteUser(int id) {
        addressRepository.deleteById(id);
    }

    public void updateUser(int id, Address address) {

    }


}
