package itechart.bookingservice.repository;

import itechart.bookingservice.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Integer> {
    Place getById(int id);
}
