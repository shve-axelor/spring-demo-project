package com.rest.api.demoproject.controller;

import com.rest.api.demoproject.entities.Employee;
import com.rest.api.demoproject.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/demoproject/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return new ResponseEntity<>(employeeService.getAll().stream().sorted().collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getOneEmployee(@PathVariable Long id){
        Optional<Employee> employee = Optional.ofNullable(employeeService.getOneEmployee(id)) ;
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.FOUND)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
            Employee existingEmployee = employeeService.getOneEmployee(id);
            if(existingEmployee != null){
                employeeService.deleteEmployee(existingEmployee);
                return new ResponseEntity<>("Successfully Deleted.",HttpStatus.OK);
            }
            return new ResponseEntity<>("Record Not Found.", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee existingEmployee = employeeService.getOneEmployee(id);
        if (existingEmployee != null) {
            employee.setId(id);
            return new ResponseEntity<>(employeeService.updateEmployee(employee),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
