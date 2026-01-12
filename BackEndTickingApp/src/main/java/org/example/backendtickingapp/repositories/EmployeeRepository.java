package org.example.backendtickingapp.repositories;

import org.example.backendtickingapp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByUsername(String username);
}
