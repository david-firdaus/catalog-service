package id.co.davidfirdaus.travel.catalogservice.config;

import id.co.davidfirdaus.travel.catalogservice.destinations.boundary.DestinationResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JaxRsConfig extends ResourceConfig {
    public JaxRsConfig() {
        register(DestinationResource.class);
        register(GenericExceptionHandler.class);

    }
}
