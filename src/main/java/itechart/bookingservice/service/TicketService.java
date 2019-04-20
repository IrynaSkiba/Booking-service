package itechart.bookingservice.service;

import itechart.bookingservice.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public interface TicketService {
    void saveTickets(ArrayList<Ticket> tickets);
    List<Ticket> getTickets(int id);

    Ticket buyTicket(Ticket ticket, int userId);
}
