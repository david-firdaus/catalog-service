package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service;

import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.PriceDetailRepository;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.PriceDetail;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class GetPackagePriceBL {
    public static final int DEFAULT_SIZE = 10;

    @Autowired
    PriceDetailRepository priceDetailRepository;

    public Iterable<PriceDetail> getTravelPackages(int page, int size) {
        PageRequest pageable = new PageRequest(page, size < 1 ? DEFAULT_SIZE : size);
        return priceDetailRepository.findAll(pageable).getContent();
    }

    public PriceDetail getTravelPackage(Long id) {
        return priceDetailRepository.findOne(id);
    }
}
