package itechart.bookingservice.service.impl;

import itechart.bookingservice.model.Event;
import itechart.bookingservice.repository.EventRepository;
import itechart.bookingservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public void createEvent(Event eventDto) {
        Event event = new Event();
        event.setDateTime(eventDto.getDateTime());
        event.setAgeLimit(eventDto.getAgeLimit());
        event.setImage(eventDto.getImage());
        event.setName(eventDto.getName());
        event.setPlaceId(eventDto.getPlaceId());
        event.setCategoryId(eventDto.getCategoryId());
        eventRepository.save(event);
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }
}
