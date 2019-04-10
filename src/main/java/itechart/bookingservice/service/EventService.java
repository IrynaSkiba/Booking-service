package itechart.bookingservice.service;

import itechart.bookingservice.model.Event;

import java.util.List;

public interface EventService {
    void createEvent(Event event);
    List<Event> getEvents();
}
