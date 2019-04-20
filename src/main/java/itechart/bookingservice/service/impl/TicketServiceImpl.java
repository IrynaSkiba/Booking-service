package itechart.bookingservice.service.impl;

import itechart.bookingservice.model.Ticket;
import itechart.bookingservice.repository.TicketRepository;
import itechart.bookingservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void saveTickets(ArrayList<Ticket> tickets) {
        ticketRepository.saveAll(tickets);
    }

    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getTicketsByEventId(int id) {
        return ticketRepository.getTicketsByEventId(id);
    }

    @Override
    public void buyTicket(Ticket ticket, int userId) {
        ticket.setUserId(userId);
        ticketRepository.save(ticket);
        return;
    }

    @Override
    public List<Ticket> getTicketsByUserId(int id) {
        return ticketRepository.getTicketsByUserId(id);
    }
}