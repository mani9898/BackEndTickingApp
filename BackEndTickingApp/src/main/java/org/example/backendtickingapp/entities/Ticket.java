package org.example.backendtickingapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.example.backendtickingapp.model.TicketStatus;

@Entity(name= "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "price")
    private double price;
    @Column(nullable = false, name = "description", length = 500)
    @NotEmpty(message = "Description must not be empty")
    private String description;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    public Ticket() {
    }
    public Ticket(double price, String description, TicketStatus status) {
        this.price = price;
        this.description = description;
        this.status = status;
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
