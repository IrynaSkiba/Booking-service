package itechart.bookingservice.controller;

import itechart.bookingservice.model.Ticket;
import itechart.bookingservice.service.impl.TicketServiceImpl;
import itechart.bookingservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private TicketServiceImpl ticketService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("tickets")
    public List<Ticket> getTickets(Principal currentUser) {
        return ticketService.getTicketsByUserId(userService.findByEmail(currentUser.getName()).getId());
    }
}
