package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service;

import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.PriceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractPackagePriceBL {
    @Autowired
    PriceDetailRepository priceDetailRepository;

    @Autowired
    ValidateTravelPackageBL validateTravelPackageBL;
}
