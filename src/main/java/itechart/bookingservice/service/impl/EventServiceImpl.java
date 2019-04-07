package itechart.bookingservice.service.impl;

import itechart.bookingservice.model.Event;
import itechart.bookingservice.repository.EventRepository;
import itechart.bookingservice.service.EventService;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void crateEvent(Event eventDto) {
        Event event = new Event();
        event.setDateTime(eventDto.getDateTime());
        event.setAgeLimit(eventDto.getAgeLimit());
        event.setImage(eventDto.getImage());
        event.setName(eventDto.getName());
        eventRepository.save(event);
    }
}
