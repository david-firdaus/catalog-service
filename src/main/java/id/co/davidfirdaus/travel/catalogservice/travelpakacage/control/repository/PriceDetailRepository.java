package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository;

import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.PriceDetail;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.TravelPackage;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PriceDetailRepository extends PagingAndSortingRepository<PriceDetail, Long> {
}
