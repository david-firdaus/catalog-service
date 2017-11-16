package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service;

import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.ItineraryDetailRepository;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.TravelPackageRepository;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.ItineraryDetail;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.TravelPackage;
import org.springframework.beans.factory.annotation.Autowired;

public class AddItineraryBL {
    @Autowired
    TravelPackageRepository travelPackageRepository;

    @Autowired
    ValidateTravelPackageBL validateTravelPackageBL;

    @Autowired
    ItineraryDetailRepository itineraryDetailRepository;

    public ItineraryDetail addItinerary(Long packageId, ItineraryDetail itineraryDetail) {
        validateTravelPackageBL.validateTravelPackageExists(packageId);
        TravelPackage travelPackage = travelPackageRepository.findOne(packageId);
        itineraryDetail.setTravelPackage(travelPackage);

        return itineraryDetailRepository.save(itineraryDetail);
    }
}
