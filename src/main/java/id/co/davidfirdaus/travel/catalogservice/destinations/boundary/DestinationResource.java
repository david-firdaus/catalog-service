package id.co.davidfirdaus.travel.catalogservice.destinations.boundary;

import id.co.davidfirdaus.travel.catalogservice.destinations.control.AddDestinationBL;
import id.co.davidfirdaus.travel.catalogservice.destinations.control.DeleteDestinationBL;
import id.co.davidfirdaus.travel.catalogservice.destinations.control.GetDestinationBL;
import id.co.davidfirdaus.travel.catalogservice.destinations.control.UpdateDestinationBL;
import id.co.davidfirdaus.travel.catalogservice.destinations.entity.Destination;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("destinations")
public class DestinationResource {

    @Autowired
    GetDestinationBL getDestinationBL;

    @Autowired
    UpdateDestinationBL updateDestinationBL;

    @Autowired
    AddDestinationBL addDestinationBL;

    @Autowired
    DeleteDestinationBL deleteDestinationBL;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDestination(@PathParam("id") Long id) {
        Destination destination = getDestinationBL.getDestination(id);
        if (destination == null) {
            throw new NotFoundException(String.format("Destination with id: %s not found.", id));
        }
        return Response.ok().entity(destination).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDestinations(@QueryParam("page") int page, @QueryParam("size") int size) {
        return Response.ok().entity(getDestinationBL.getAllDestination(page, size)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDestination(Destination destination) {
        return Response.ok().entity(addDestinationBL.addDestination(destination)).build();
    }

    @POST
    @Path("/{id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDestination(@PathParam("id") Long id, Destination destination) {
        return Response.ok().entity(updateDestinationBL.updateDestination(id, destination)).build();
    }

    @POST
    @Path("/{id}/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteDestination(@PathParam("id") Long id, Destination destination) {
        deleteDestinationBL.deleteDestination(id);
        return Response.ok().build();
    }
}
