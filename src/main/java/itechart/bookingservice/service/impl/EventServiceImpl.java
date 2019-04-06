package itechart.bookingservice.service.impl;

import itechart.bookingservice.model.Event;
import itechart.bookingservice.repository.EventRepository;
import itechart.bookingservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventRepository;

    @Override
    public void crateEvent(Event eventDto) {
        Event event = new Event();
  /*      event.setPlace(eventDto.getPlace());
        event.setCategory(eventDto.getCategory());*/
        event.setDateTime(eventDto.getDateTime());
        event.setAgeLimit(eventDto.getAgeLimit());
        event.setImage(eventDto.getImage());
        eventRepository.save(event);
    }
}
