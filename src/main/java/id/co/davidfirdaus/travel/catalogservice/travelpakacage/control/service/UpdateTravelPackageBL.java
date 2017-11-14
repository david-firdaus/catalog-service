package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service;

import id.co.davidfirdaus.travel.catalogservice.commons.exception.BusinessException;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.TravelPackageRepository;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.PackageStatus;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.PackageType;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.TravelPackage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Log4j2
@Component
public class UpdateTravelPackageBL {
    @Autowired
    TravelPackageRepository travelPackageRepository;

    public TravelPackage updateTravelPackage(Long id, TravelPackage data) {
        TravelPackage travelPackage = travelPackageRepository.findOne(id);
        if (travelPackage != null ){
            updateStatus(data.getStatus(), travelPackage);
            updateType(data.getType(), travelPackage);
            updateName(data.getName(), travelPackage);
            updatePrice(data.getEstimatePrice(), travelPackage);
            updateTermAndCondition(data.getTermAndCondition(), travelPackage);
            travelPackage = travelPackageRepository.save(travelPackage);
        } else {
            throw new BusinessException("id", "Package record with id: %id not found");
        }

        return travelPackage;
    }

    void updateTermAndCondition(String termAndCondition, TravelPackage travelPackage) {
        if (termAndCondition != null) {
            travelPackage.setTermAndCondition(termAndCondition);
        }
    }

    void updatePrice(BigDecimal estimatePrice, TravelPackage travelPackage) {
        if (estimatePrice != null) {
            travelPackage.setEstimatePrice(estimatePrice);
        }
    }

    void updateName(String name, TravelPackage travelPackage) {
        if (name != null) {
            travelPackage.setName(name);
        }
    }

    void updateType(PackageType type, TravelPackage travelPackage) {
        if (type != null) {
            travelPackage.setType(type);
        }
    }

    void updateStatus(PackageStatus status, TravelPackage travelPackage) {
        if (status !=null) {
            travelPackage.setStatus(status);
        }
    }
}
