package org.example.backendtickingapp.services;

import org.example.backendtickingapp.entities.Employee;
import org.example.backendtickingapp.exceptions.EmployeeLoginException;
import org.example.backendtickingapp.model.EmployeeRole;
import org.example.backendtickingapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordHasher passwordHasher;


    public Employee login(String username, String password) {
        Employee employee = employeeRepository.findByUsername(username);
        if(employee != null && passwordHasher.checkPassword(password, employee.getPassword())) {
            return employee;
        } else  {
            throw new EmployeeLoginException();
        }
    }

    public Employee register(Employee employee) {
        if(employeeRepository.findByUsername(employee.getUsername()) != null) {
             throw new EmployeeLoginException("Employee already exists");
        }

        employee.setPassword(passwordHasher.hashPassword(employee.getPassword()));
        employee.setRole(EmployeeRole.EMPLOYEE);
        employee = employeeRepository.save(employee);
        return employee;
    }

    public boolean isEmployeeExists(String username) {
        return employeeRepository.findByUsername(username) != null;
    }

    public void testMehthod(){

    }

}
