package itechart.bookingservice.service.impl;

import itechart.bookingservice.repository.PlaceRepository;
import itechart.bookingservice.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    private PlaceRepository placeRepository;
    @Override
    public int getCountTicketsById(int id) {
        return  placeRepository.getById(id).getCountTickets();
    }
}
