package org.example.backendtickingapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.example.backendtickingapp.model.EmployeeRole;

@Entity(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(unique = true, nullable = false, name = "username", length = 50)
    private String username;
    @NotEmpty
    @Column(nullable = false, name = "password", length = 100)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "role", length = 20)
    private EmployeeRole role;

    public Employee() {
    }
    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeRole getRole() {
        return role;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
