package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service;

import id.co.davidfirdaus.travel.catalogservice.commons.exception.BusinessException;
import id.co.davidfirdaus.travel.catalogservice.destinations.control.DestinationRepository;
import id.co.davidfirdaus.travel.catalogservice.destinations.entity.Destination;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.ItineraryDetailRepository;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.TravelPackageRepository;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.ItineraryDetail;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.TravelPackage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class AddItineraryBL {
    @Autowired
    TravelPackageRepository travelPackageRepository;

    @Autowired
    ValidateTravelPackageBL validateTravelPackageBL;

    @Autowired
    ItineraryDetailRepository itineraryDetailRepository;

    @Autowired
    DestinationRepository destinationRepository;

    public ItineraryDetail addItinerary(Long packageId, ItineraryDetail itineraryDetail) {
        validateTravelPackageBL.validateTravelPackageExists(packageId);
        TravelPackage travelPackage = travelPackageRepository.findOne(packageId);
        itineraryDetail.setTravelPackage(travelPackage);

        Destination destination = getDestination(itineraryDetail.getDestination().getId());
        itineraryDetail.setDestination(destination);

        return itineraryDetailRepository.save(itineraryDetail);
    }

    Destination getDestination(Long id) {
        Destination destination = destinationRepository.findOne(id);
        if (destination == null) {
            throw new BusinessException("Destination", "Invalid data, destination field.");
        }
        return destination;
    }
}
