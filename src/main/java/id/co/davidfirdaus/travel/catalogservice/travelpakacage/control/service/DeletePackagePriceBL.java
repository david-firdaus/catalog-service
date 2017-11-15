package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service;

import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.PriceDetailRepository;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.TravelPackageRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class DeletePackagePriceBL extends AbstractPackagePriceBL{

    @Autowired
    ValidatePriceDetailBL validatePriceDetailBL;

    @Autowired
    TravelPackageRepository travelPackageRepository;

    @Autowired
    PriceDetailRepository priceDetailRepository;

    public void deletePrice(Long packageId, Long id) {
        validateTravelPackageBL.validateTravelPackageExists(packageId);
        validatePriceDetailBL.validatePriceDetailExists(id);

        priceDetailRepository.delete(id);
    }
}
