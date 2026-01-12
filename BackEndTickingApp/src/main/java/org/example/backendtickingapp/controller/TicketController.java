package org.example.backendtickingapp.controller;

import org.example.backendtickingapp.entities.Ticket;
import org.example.backendtickingapp.exceptions.EmployeeNotFoundException;
import org.example.backendtickingapp.exceptions.InvalidTicketStatusType;
import org.example.backendtickingapp.model.TicketStatus;
import org.example.backendtickingapp.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @GetMapping("/tickets/{userName}")
    public ResponseEntity <List<Ticket>> getTickets(@PathVariable String userName) throws EmployeeNotFoundException {
        List<Ticket> tickets = ticketService.getTicketsByUserName(userName);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @PostMapping("/tickets/create")
    public ResponseEntity<Ticket> insert(@RequestBody Ticket ticket) throws  EmployeeNotFoundException {
        ticket.setStatus(TicketStatus.PENDING);
        ticket = this.ticketService.insertTicket(ticket);
        if(ticket != null) return new ResponseEntity<>(ticket, HttpStatus.CREATED);
        else return new ResponseEntity<>(ticket, HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/tickets/update/{ticketId}/{status}")
    public ResponseEntity<Ticket> updateTicketStatus(@PathVariable Long ticketId, @PathVariable TicketStatus status) throws InvalidTicketStatusType {
        Ticket updatedTicket = ticketService.updateTicketStatus(ticketId, status);
        if (updatedTicket != null) {
            return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tickets/v1/{status}")
    public ResponseEntity<List<Ticket>> getTicketsByStatus(@PathVariable String status) {
        List<Ticket> tickets = ticketService.findAllTicketsByStatus(status);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/tickets/orderbydate/{userName}")
    public ResponseEntity<List<Ticket>> getTicketsByUserName(@PathVariable String userName) {
        List<Ticket> tickets = ticketService.findAllTicketsByAccendingDate(userName);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

}
