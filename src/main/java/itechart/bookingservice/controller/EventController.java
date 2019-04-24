package itechart.bookingservice.controller;

import itechart.bookingservice.dto.CommentDto;
import itechart.bookingservice.dto.EventDto;
import itechart.bookingservice.dto.LikeDto;
import itechart.bookingservice.model.Event;
import itechart.bookingservice.model.Ticket;
import itechart.bookingservice.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    private LikeServiceImpl likeService;
    @Autowired
    private CommentServiceImpl commentService;

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
        return ticketService.getTicketsByEventId(event.getId());
    }

    @GetMapping("events/{id}/tickets/{idTicket}")
    public Ticket buyTicket(@PathVariable("idTicket") Ticket ticket, Principal currentUser) {
        ticketService.buyTicket(ticket, userService.getIdOfCurrentUser(currentUser));
        return ticket;
    }

    @PutMapping("events/{id}/likes")
    public void setLike(@RequestBody LikeDto likeDto, @PathVariable("id") Event event, Principal currentUser) {
        likeService.setLike(likeDto.getIsLike(), userService.getIdOfCurrentUser(currentUser), event.getId());
    }

    @PutMapping("events/{id}/comments")
    public void addComment(@RequestBody CommentDto commentDto, @PathVariable("id") Event event, Principal currentUser) {
        commentService.addComment(commentDto.getText(), userService.getIdOfCurrentUser(currentUser), event.getId());
    }
}
