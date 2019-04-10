package itechart.bookingservice.controller;

import itechart.bookingservice.model.Event;
import itechart.bookingservice.repository.EventRepository;
import itechart.bookingservice.service.impl.EventServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    private EventServiceImpl eventService;
    private EventRepository eventRepository;

    public EventController(EventServiceImpl eventService, EventRepository eventRepository) {
        this.eventService = eventService;
        this.eventRepository = eventRepository;
    }

    @GetMapping("events/{id}")
    public Event getEvent(@PathVariable("id") Event event) {
        return event;
    }

    @GetMapping("events")
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @PostMapping("events")
    @PreAuthorize("hasRole('ADMIN')")
    public Event createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
        return event;
    }
}
