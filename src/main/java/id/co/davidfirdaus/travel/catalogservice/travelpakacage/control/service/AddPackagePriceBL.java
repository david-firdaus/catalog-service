package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service;

import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.TravelPackageRepository;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.PriceDetail;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.TravelPackage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class AddPackagePriceBL extends AbstractPackagePriceBL {
    @Autowired
    TravelPackageRepository travelPackageRepository;

    public PriceDetail addPriceDetail(Long packageId, PriceDetail priceDetail) {
        validateTravelPackageBL.validateTravelPackageExists(packageId);
        TravelPackage travelPackage = travelPackageRepository.findOne(packageId);
        priceDetail.setTravelPackage(travelPackage);

        return priceDetailRepository.save(priceDetail);
    }
}
