package com.rest.api.demoproject.service.impl;

import com.rest.api.demoproject.entities.Employee;
import com.rest.api.demoproject.repositories.EmployeeRepository;
import com.rest.api.demoproject.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getOneEmployee(Long id) {
        return employeeRepository.findById(id).orElseGet(() -> null);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


}
