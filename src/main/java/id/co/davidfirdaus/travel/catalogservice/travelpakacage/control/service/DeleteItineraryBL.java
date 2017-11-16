package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service;

import id.co.davidfirdaus.travel.catalogservice.commons.exception.BusinessException;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.ItineraryDetailRepository;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.TravelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteItineraryBL {
    @Autowired
    TravelPackageRepository travelPackageRepository;

    @Autowired
    ValidateTravelPackageBL validateTravelPackageBL;

    @Autowired
    ItineraryDetailRepository itineraryDetailRepository;

    public void deleteItinerary(Long packageId, Long id) {
        validateTravelPackageBL.validateTravelPackageExists(packageId);
        boolean exists = itineraryDetailRepository.exists(id);
        if (!exists) {
            throw new BusinessException("Itinerary", String.format("Itinerary with id: %s not found", id));
        }

        itineraryDetailRepository.delete(id);
    }
}
