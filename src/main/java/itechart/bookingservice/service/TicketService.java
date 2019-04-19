package itechart.bookingservice.service;

import itechart.bookingservice.model.Ticket;

import java.util.ArrayList;

public interface TicketService {
    void saveTickets(ArrayList<Ticket> tickets);
}
