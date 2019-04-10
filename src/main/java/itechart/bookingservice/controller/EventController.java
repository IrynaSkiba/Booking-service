package itechart.bookingservice.controller;

import itechart.bookingservice.model.Event;
import itechart.bookingservice.repository.EventRepository;
import itechart.bookingservice.service.impl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventServiceImpl eventService;

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
    public Event createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
        return event;
    }
}
