package itechart.bookingservice.controller;

import itechart.bookingservice.model.Event;
import itechart.bookingservice.repository.EventRepository;
import itechart.bookingservice.service.impl.EventServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
