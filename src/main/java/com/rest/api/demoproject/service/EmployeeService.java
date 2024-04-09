package com.rest.api.demoproject.service;

import com.rest.api.demoproject.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> getAll();

    public Employee addEmployee(Employee employee);

    public Employee getOneEmployee(Long id);

    public void deleteEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);
}
