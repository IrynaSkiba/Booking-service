package itechart.bookingservice.controller;

import itechart.bookingservice.model.Event;
import itechart.bookingservice.service.impl.EventServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    private EventServiceImpl eventService;

    public EventController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @PostMapping("events")
    @PreAuthorize("hasRole('ADMIN')")
    public void createEvent(@RequestBody Event event) {
        eventService.crateEvent(event);
    }
}
