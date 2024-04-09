package com.rest.api.demoproject.controller;

import com.rest.api.demoproject.entities.Address;
import com.rest.api.demoproject.entities.Employee;
import com.rest.api.demoproject.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demoproject/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress() {
        return new ResponseEntity<>(addressService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        return new ResponseEntity<>(addressService.addAddress(address), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getOneAddress(@PathVariable Long id){
        Optional<Address> address = Optional.ofNullable(addressService.getOneAddress(id)) ;
        return address.map(value -> new ResponseEntity<>(value, HttpStatus.FOUND)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        Address existingAddress = addressService.getOneAddress(id);
        if(existingAddress != null){
            addressService.deleteAddress(existingAddress);
            return new ResponseEntity<>("Successfully Deleted.",HttpStatus.OK);
        }
        return new ResponseEntity<>("Record Not Found.", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address){
        Address existingAddress = addressService.getOneAddress(id);
        if (existingAddress != null) {
            address.setId(id);
            return new ResponseEntity<>(addressService.updateAddress(address),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
