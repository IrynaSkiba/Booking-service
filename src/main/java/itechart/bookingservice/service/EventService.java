package itechart.bookingservice.service;

import itechart.bookingservice.dto.EventDto;
import itechart.bookingservice.model.Event;

import java.util.List;

public interface EventService {
    Event createEvent(EventDto event);
    List<Event> getEvents();
}
