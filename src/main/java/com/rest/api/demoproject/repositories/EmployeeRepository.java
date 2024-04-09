package com.rest.api.demoproject.repositories;

import com.rest.api.demoproject.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
