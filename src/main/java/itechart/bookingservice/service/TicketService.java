package itechart.bookingservice.service;

import itechart.bookingservice.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public interface TicketService {
    void saveTickets(ArrayList<Ticket> tickets);
    List<Ticket> getTicketsByEventId(int id);
    List<Ticket> getTicketsByUserId(int id);
    void buyTicket(Ticket ticket, int userId);
}
