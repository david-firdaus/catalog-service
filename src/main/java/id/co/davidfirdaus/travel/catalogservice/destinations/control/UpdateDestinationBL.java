package id.co.davidfirdaus.travel.catalogservice.destinations.control;

import id.co.davidfirdaus.travel.catalogservice.commons.exception.BusinessException;
import id.co.davidfirdaus.travel.catalogservice.destinations.entity.City;
import id.co.davidfirdaus.travel.catalogservice.destinations.entity.Country;
import id.co.davidfirdaus.travel.catalogservice.destinations.entity.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateDestinationBL {
    @Autowired
    DestinationRepository destinationRepository;

    public Destination updateDestination(Long id, Destination data) throws BusinessException {
        Destination destination = destinationRepository.findOne(id);
        if (destination != null) {
            updateCity(data.getCity(), destination);
            updateCountry(data.getCountry(), destination);
            updateName(data.getName(), destination);
            updateNote(data.getNote(), destination);
            destination = destinationRepository.save(destination);

        } else {
            throw new BusinessException("id", "Destination record with id: %id not found");
        }

        return destination;
    }

    void updateCity(City city, Destination des) {
        if (city != null) {
            des.setCity(city);
        }
    }

    void updateCountry(Country country, Destination destination) {
        if (country != null) {
            destination.setCountry(country);
        }
    }

    void updateName(String name, Destination destination) {
        if (name != null) {
            destination.setName(name);
        }
    }

    void updateNote(String note, Destination destination) {
        if (note != null) {
            destination.setNote(note);
        }
    }
}
