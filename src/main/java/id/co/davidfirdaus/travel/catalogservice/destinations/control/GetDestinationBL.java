package id.co.davidfirdaus.travel.catalogservice.destinations.control;

import id.co.davidfirdaus.travel.catalogservice.destinations.entity.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.ws.rs.NotFoundException;

@Component
public class GetDestinationBL {
    public static final int DEFAULT_SIZE = 10;

    @Autowired
    DestinationRepository destinationRepository;

    public Destination getDestination(Long id) throws NotFoundException {
        return destinationRepository.findOne(id);
    }

    public Iterable<Destination> getAllDestination(Integer page, Integer size){
        PageRequest pageable = new PageRequest(page, size < 1 ? DEFAULT_SIZE : size);
        return destinationRepository.findAll(pageable).getContent();
    }
}
