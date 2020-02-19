package cz.uhk.fim.pro3.attendence.service;

import cz.uhk.fim.pro3.attendence.dao.AddressRepository;
import cz.uhk.fim.pro3.attendence.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Optional<Address> getAddress(int id) {
        return addressRepository.findById(id);
    }

    public void deleteAddress(int id){
        addressRepository.deleteById(id);
    }

    public void updateAddress(int id, Address address){
        Address oldAddress = getAddress(id).get();
        oldAddress.setCity(address.getCity());
        oldAddress.setState(address.getState());
        oldAddress.setStreet(address.getStreet());
        oldAddress.setZip(address.getZip());
        addressRepository.save(oldAddress);

    }
}
