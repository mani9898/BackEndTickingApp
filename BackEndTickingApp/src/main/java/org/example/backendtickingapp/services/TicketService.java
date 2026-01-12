package org.example.backendtickingapp.services;

import org.example.backendtickingapp.entities.Ticket;
import org.example.backendtickingapp.exceptions.EmployeeNotFoundException;
import org.example.backendtickingapp.exceptions.InvalidTicketStatusType;
import org.example.backendtickingapp.model.TicketStatus;
import org.example.backendtickingapp.repositories.EmployeeRepository;
import org.example.backendtickingapp.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;


    public Ticket insertTicket(Ticket ticket) {
        ticket.setCreatedAt(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }


    Ticket findById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.orElse(null);
    }

    public List<Ticket> findAllTicketsByStatus(String status) {
        // return all tickets with status status
        if (status.equalsIgnoreCase(TicketStatus.PENDING.name())) {
            return ticketRepository.findByStatus(TicketStatus.PENDING);
        } else if (status.equalsIgnoreCase(TicketStatus.APPROVED.name())) {
            return ticketRepository.findByStatus(TicketStatus.APPROVED);
        } else if (status.equalsIgnoreCase(TicketStatus.DENIED.name())) {
            return ticketRepository.findByStatus(TicketStatus.DENIED);
        } else {
            return new ArrayList<>();
        }
    }

    public List<Ticket> findAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        ticketRepository.findAll().forEach(tickets::add);
        return tickets;
    }

    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> findAllTicketsByAccendingDate(String username) {
        return ticketRepository.findByUsernameOrderByCreatedAtAsc(username);
    }

    public List<Ticket> getTicketsByUserName(String userName) throws EmployeeNotFoundException {

        if (userName == null) {
            throw new EmployeeNotFoundException("Employee not found ");
        }
        return ticketRepository.findByUsername(userName);
    }

    public Ticket createTicketForUser(String userName) throws EmployeeNotFoundException {
        if (userName == null) {
            throw new EmployeeNotFoundException("Employee not found ");
        }
        Ticket ticket = new Ticket();
        ticket.setUsername(userName);
        ticket.setStatus(TicketStatus.PENDING);
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicketStatus(Long ticketId, TicketStatus status) throws InvalidTicketStatusType {
        if(ticketId == null || status == null) {
            return null;
        }
        if(!status.equals(TicketStatus.PENDING) && !status.equals(TicketStatus.APPROVED) && !status.equals(TicketStatus.DENIED)) {
            throw new InvalidTicketStatusType();
        }
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setStatus(status);
            return ticketRepository.save(ticket);
        }
        return null;
    }

}
