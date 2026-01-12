package org.example.backendtickingapp.controller;

import jakarta.validation.Valid;
import org.example.backendtickingapp.DTO.LoginDTO;
import org.example.backendtickingapp.entities.Employee;
import org.example.backendtickingapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/registerEmployee")
    public ResponseEntity<Employee> register(@RequestBody Employee employee) {
        employee = this.employeeService.register(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Employee> login(@Valid @RequestBody LoginDTO loginDTO) {
        Employee employee = this.employeeService.login(loginDTO.getUsername(), loginDTO.getPassword());
        if (employee != null) {
            employee.setPassword(null); // avoid returning password
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
