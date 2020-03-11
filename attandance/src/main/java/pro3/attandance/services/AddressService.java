package pro3.attandance.services;


import org.springframework.stereotype.Service;
import pro3.attandance.model.Address;
import pro3.attandance.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements BaseService<Address> {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAll() {
        return (List<Address>) addressRepository.findAll();
    }

    @Override
    public Optional<Address> getById(int id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address add(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteById(int id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address update(int id, Address address) {
        return addressRepository.save(address);
    }
}
