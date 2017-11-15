package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service;

import id.co.davidfirdaus.travel.catalogservice.commons.exception.BusinessException;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.PriceDetailRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ValidatePriceDetailBL {
    @Autowired
    PriceDetailRepository priceDetailRepository;

    public Boolean isPriceDetailExists(Long id) {
        return priceDetailRepository.exists(id);
    }

    public void validatePriceDetailExists(Long id) {
        if (!isPriceDetailExists(id)) {
            throw new BusinessException("Package", String.format("Price detail with id: %s not found", id));
        }
    }
}
