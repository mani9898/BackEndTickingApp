package org.example.backendtickingapp.repositories;

import org.example.backendtickingapp.entities.Ticket;
import org.example.backendtickingapp.model.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    List<Ticket> findByStatus(TicketStatus status);

    List<Ticket> findAllByOrderByCreatedAtAsc();

    List<Ticket> findByUsername(String userName);

    List<Ticket> findByUsernameOrderByCreatedAtAsc(String username);
}
