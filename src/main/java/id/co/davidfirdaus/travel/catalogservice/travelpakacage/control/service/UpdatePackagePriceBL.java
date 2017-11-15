package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service;

import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.PriceDetail;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Log4j2
@Component
public class UpdatePackagePriceBL extends AbstractPackagePriceBL{

    public PriceDetail updatePriceDetail(Long packageId, Long id, PriceDetail data) {
        validateTravelPackageBL.validateTravelPackageExists(packageId);
        PriceDetail priceDetail = priceDetailRepository.findOne(id);
        if (priceDetail != null) {
            updatePrice(priceDetail, data.getPrice());
            updateDays(priceDetail, data.getDays());
            updateNights(priceDetail, data.getNights());
            updateDepartureDate(priceDetail, data.getDepartureDate());
            updateNote(priceDetail, data.getNote());
            priceDetailRepository.save(priceDetail);
        }

        return priceDetail;
    }

    void updateNote(PriceDetail priceDetail, String note) {
        if (note != null) {
            priceDetail.setNote(note);
        }
    }

    void updateDepartureDate(PriceDetail priceDetail, Date departureDate) {
        if (departureDate != null) {
            priceDetail.setDepartureDate(departureDate);
        }
    }

    void updateNights(PriceDetail priceDetail, Integer nights) {
        if (nights != null) {
            priceDetail.setNights(nights);
        }
    }

    void updateDays(PriceDetail priceDetail, Integer days) {
        if (days != null) {
            priceDetail.setDays(days);
        }
    }

    void updatePrice(PriceDetail priceDetail, BigDecimal price) {
        if (price != null) {
            priceDetail.setPrice(price);
        }
    }
}
