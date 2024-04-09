package com.rest.api.demoproject.service;

import com.rest.api.demoproject.entities.Address;

import java.util.List;

public interface AddressService {

    public List<Address> getAll();

    public Address addAddress(Address address);

    public Address getOneAddress(Long id);

    public void deleteAddress(Address address);

    public Address updateAddress(Address address);
}
