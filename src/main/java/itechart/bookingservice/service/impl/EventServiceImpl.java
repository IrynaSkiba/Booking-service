package itechart.bookingservice.service.impl;

import itechart.bookingservice.dto.EventDto;
import itechart.bookingservice.model.Event;
import itechart.bookingservice.model.Ticket;
import itechart.bookingservice.repository.EventRepository;
import itechart.bookingservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private PlaceServiceImpl placeService;
    @Autowired
    private TicketServiceImpl ticketService;

    @Override
    public Event createEvent(EventDto eventDto) {
        Event event = new Event(eventDto);
        eventRepository.save(event);
        int size = placeService.getCountTicketsById(eventDto.getPlaceId());

        ArrayList<Ticket> tickets = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Ticket ticket = new Ticket(event.getId(), eventDto.getPrice());
            tickets.add(ticket);
        }
         ticketService.saveTickets(tickets);
        return event;
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }
}
