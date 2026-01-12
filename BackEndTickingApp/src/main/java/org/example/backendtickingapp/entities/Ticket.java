package org.example.backendtickingapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.example.backendtickingapp.model.TicketStatus;

import java.time.LocalDateTime;

@Entity(name= "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "price")
    private double price;
    @Column(nullable = false, name = "description", length = 500)
    @NotEmpty(message = "Description must not be empty")
    private String description;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Ticket() {
    }

    public Ticket(String username, double price, String description, TicketStatus status) {
        this.username = username;
        this.price = price;
        this.description = description;
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
