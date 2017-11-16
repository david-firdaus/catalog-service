package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service;

import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.ItineraryDetailRepository;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.ItineraryDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

public class GetItineraryBL {
    public static final int DEFAULT_SIZE = 10;

    @Autowired
    ItineraryDetailRepository itineraryDetailRepository;

    public Iterable<ItineraryDetail> getItineraries(int page, int size) {
        PageRequest pageable = new PageRequest(page, size < 1 ? DEFAULT_SIZE : size);
        return itineraryDetailRepository.findAll(pageable).getContent();
    }

    public ItineraryDetail getItinerary(Long id) {
        return itineraryDetailRepository.findOne(id);
    }
}
