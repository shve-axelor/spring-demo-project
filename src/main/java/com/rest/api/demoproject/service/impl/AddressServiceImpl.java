package com.rest.api.demoproject.service.impl;

import com.rest.api.demoproject.entities.Address;
import com.rest.api.demoproject.entities.Employee;
import com.rest.api.demoproject.repositories.AddressRepository;
import com.rest.api.demoproject.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.saveAndFlush(address);
    }

    @Override
    public Address getOneAddress(Long id) {
        return addressRepository.findById(id).orElseGet(() -> null);
    }

    @Override
    public void deleteAddress(Address address) {
        addressRepository.delete(address);
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }
}
