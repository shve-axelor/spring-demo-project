package com.rest.api.demoproject.repositories;

import com.rest.api.demoproject.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
