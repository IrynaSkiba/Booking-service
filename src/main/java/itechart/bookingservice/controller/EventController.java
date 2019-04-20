package itechart.bookingservice.controller;

import itechart.bookingservice.dto.EventDto;
import itechart.bookingservice.model.Event;
import itechart.bookingservice.model.Ticket;
import itechart.bookingservice.model.User;
import itechart.bookingservice.service.impl.EventServiceImpl;
import itechart.bookingservice.service.impl.TicketServiceImpl;
import itechart.bookingservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventServiceImpl eventService;
    @Autowired
    private TicketServiceImpl ticketService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("events/{id}")
    public Event getEvent(@PathVariable("id") Event event) {
        return event;
    }

    @GetMapping("events")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @PostMapping("events")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Event> createEvent(@RequestBody EventDto eventDto) {
        eventService.createEvent(eventDto);
        return eventService.getEvents();
    }

    @GetMapping("events/{id}/tickets")
    public List<Ticket> getTickets(@PathVariable("id") Event event) {
        return ticketService.getTickets(event.getId());
    }

    @GetMapping("events/{id}/tickets/{idTicket}")
    public Ticket buyTicket(@PathVariable("idTicket") Ticket ticket, Principal currentUser) {
        ticketService.buyTicket(ticket, userService.findByEmail(currentUser.getName()).getId());
        return ticket;
    }
}
