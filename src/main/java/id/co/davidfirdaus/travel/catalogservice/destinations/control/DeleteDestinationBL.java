package id.co.davidfirdaus.travel.catalogservice.destinations.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteDestinationBL {
    @Autowired
    DestinationRepository destinationRepository;

    public void deleteDestination (Long id) {
        destinationRepository.delete(id);
    }
}
