package id.co.davidfirdaus.travel.catalogservice.destinations.control;

import id.co.davidfirdaus.travel.catalogservice.commons.exception.BusinessException;
import id.co.davidfirdaus.travel.catalogservice.destinations.entity.City;
import id.co.davidfirdaus.travel.catalogservice.destinations.entity.Country;
import id.co.davidfirdaus.travel.catalogservice.destinations.entity.Destination;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UpdateDestinationBLTest {
    UpdateDestinationBL cut;

    @Before
    public void setUp() throws Exception {
        cut = new UpdateDestinationBL();
        cut.destinationRepository = Mockito.mock(DestinationRepository.class);
    }

    @Test(expected = BusinessException.class)
    public void whenDestinationNotFoundShouldThrowEntityNotFoundException() throws Exception {
        when(cut.destinationRepository.findOne(eq(1L))).thenReturn(null);
        cut.updateDestination(1L, new Destination());
    }

    @Test
    public void updateRecordSuccess() throws Exception {
        Destination destinationMock = new Destination();
        destinationMock.setCity(City.MALUKU);
        destinationMock.setCountry(Country.INA);
        destinationMock.setName("Bunaken");
        destinationMock.setNote("free diving training");

        when(cut.destinationRepository.findOne(eq(1L))).thenReturn(destinationMock);
        when(cut.destinationRepository.save(any(Destination.class))).then(returnsFirstArg());

        Destination actual = cut.updateDestination(1L, new Destination());
        assertThat(actual.getCity(), is(City.MALUKU));
        assertThat(actual.getCountry(), is(Country.INA));
        assertThat(actual.getName(), is("Bunaken"));
        assertThat(actual.getNote(), is("free diving training"));

        verify(cut.destinationRepository, atLeastOnce()).save(any(Destination.class));
    }
}