package id.co.davidfirdaus.travel.catalogservice.destinations.control;

import id.co.davidfirdaus.travel.catalogservice.destinations.entity.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddDestinationBL {
    @Autowired
    DestinationRepository destinationRepository;

    public Destination addDestination(Destination destination) {
        return destinationRepository.save(destination);
    }
}
