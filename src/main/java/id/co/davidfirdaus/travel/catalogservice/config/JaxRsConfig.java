package id.co.davidfirdaus.travel.catalogservice.config;

import id.co.davidfirdaus.travel.catalogservice.destinations.boundary.DestinationResource;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.boundary.PackageItineraryResource;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.boundary.PackagePriceResource;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.boundary.TravelPackageResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JaxRsConfig extends ResourceConfig {
    public JaxRsConfig() {
        register(DestinationResource.class);
        register(TravelPackageResource.class);
        register(PackageItineraryResource.class);
        register(PackagePriceResource.class);
        register(BusinessExceptionHandler.class);
        register(GenericExceptionHandler.class);

    }
}
