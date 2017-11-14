package id.co.davidfirdaus.travel.catalogservice.destinations.boundary;

import id.co.davidfirdaus.travel.catalogservice.destinations.control.DestinationService;
import id.co.davidfirdaus.travel.catalogservice.destinations.entity.Destination;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("destinations")
public class DestinationResource {

    @Autowired
    DestinationService destinationService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDestination(@PathParam("id") Long id) {
        return Response.ok().entity(destinationService.getDestination(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDestinations(@QueryParam("page") int page, @QueryParam("size") int size) {
        return Response.ok().entity(destinationService.getAllDestination(page, size)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDestination(Destination destination) {
        return Response.ok().entity(destinationService.addDestination(destination)).build();
    }
}
