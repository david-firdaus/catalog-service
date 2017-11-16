package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository;

import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.ItineraryDetail;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.TravelPackage;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItineraryDetailRepository extends PagingAndSortingRepository<ItineraryDetail, Long> {
}
