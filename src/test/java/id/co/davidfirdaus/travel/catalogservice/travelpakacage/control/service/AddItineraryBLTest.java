package id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service;

import id.co.davidfirdaus.travel.catalogservice.commons.exception.BusinessException;
import id.co.davidfirdaus.travel.catalogservice.destinations.control.DestinationRepository;
import id.co.davidfirdaus.travel.catalogservice.destinations.entity.Destination;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.repository.TravelPackageRepository;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.ItineraryDetail;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.TravelPackage;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddItineraryBLTest {
    AddItineraryBL cut;

    @Before
    public void setUp() throws Exception {
        cut = new AddItineraryBL();
    }

    @Test (expected = BusinessException.class)
    public void addItineraryErrorDueToDestinationNullOrNotFound() throws Exception {
        ItineraryDetail itineraryDetail = new ItineraryDetail();
        itineraryDetail.setDestination(new Destination());
        cut.validateTravelPackageBL = mock(ValidateTravelPackageBL.class);
        cut.travelPackageRepository = mock(TravelPackageRepository.class);
        cut.destinationRepository = mock(DestinationRepository.class);
        when(cut.travelPackageRepository.findOne(anyLong())).thenReturn(new TravelPackage());
        when(cut.destinationRepository.findOne(anyLong())).thenReturn(null);

        cut.addItinerary(1L, itineraryDetail);
    }
}