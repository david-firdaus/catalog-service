package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service;

import id.co.davidfirdaus.travel.catalogservice.commons.exception.BusinessException;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.TravelPackageRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ValidateTravelPackageBL {
    @Autowired
    TravelPackageRepository travelPackageRepository;

    public Boolean isTravelPackageExists(Long id) {
        return travelPackageRepository.exists(id);
    }

    public void validateTravelPackageExists(Long id) {
        if (!isTravelPackageExists(id)){
            throw new BusinessException("Package", String.format("Package with id: %s not found", id));
        }
    }
}
