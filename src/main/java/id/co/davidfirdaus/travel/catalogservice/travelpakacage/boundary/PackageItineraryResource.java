package id.co.davidfirdaus.travel.catalogservice.travelpakacage.boundary;

import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service.AddItineraryBL;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service.DeleteItineraryBL;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service.GetItineraryBL;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service.ValidateTravelPackageBL;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.ItineraryDetail;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Log4j2
@Path("packages/{packageId}/itineraries")
public class PackageItineraryResource {

    @Autowired
    AddItineraryBL addItineraryBL;

    @Autowired
    DeleteItineraryBL deleteItineraryBL;

    @Autowired
    GetItineraryBL getItineraryBL;

    @Autowired
    ValidateTravelPackageBL validateTravelPackageBL;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItineraries(@PathParam("packageId") Long packageId, @QueryParam("page") int page, @QueryParam("size") int size) {
        validateTravelPackageBL.validateTravelPackageExists(packageId);
        return Response.ok().entity(getItineraryBL.getItineraries(page, size)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItinerary(@PathParam("packageId") Long packageId, @PathParam("id") Long id) {
        validateTravelPackageBL.validateTravelPackageExists(packageId);
        return Response.ok(getItineraryBL.getItinerary(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addItinerary(@PathParam("packageId") Long packageId, ItineraryDetail itineraryDetail) {
        return Response.ok().entity(addItineraryBL.addItinerary(packageId, itineraryDetail)).build();
    }

    @POST
    @Path("/{id}/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteItinerary(@PathParam("packageId") Long packageId, @PathParam("id") Long id) {
        deleteItineraryBL.deleteItinerary(packageId, id);
        return Response.accepted().build();
    }
}
