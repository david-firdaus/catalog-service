package id.co.davidfirdaus.travel.catalogservice.destinations.control;

import id.co.davidfirdaus.travel.catalogservice.destinations.entity.Destination;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface DestinationRepository extends PagingAndSortingRepository<Destination, Long> {

}
