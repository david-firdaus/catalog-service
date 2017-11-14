package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service;

import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.TravelPackageRepository;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.TravelPackage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class GetTravelPackageBL {
    public static final int DEFAULT_SIZE = 10;

    @Autowired
    TravelPackageRepository travelPackageRepository;

    public Iterable<TravelPackage> getTravelPackages(int page, int size) {
        PageRequest pageable = new PageRequest(page, size < 1 ? DEFAULT_SIZE : size);
        return travelPackageRepository.findAll(pageable).getContent();
    }

    public TravelPackage getTravelPackage(Long id) {
        return travelPackageRepository.findOne(id);
    }
}
