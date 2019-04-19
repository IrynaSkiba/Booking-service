package itechart.bookingservice.service.impl;

import itechart.bookingservice.model.Ticket;
import itechart.bookingservice.repository.TicketRepository;
import itechart.bookingservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
}
