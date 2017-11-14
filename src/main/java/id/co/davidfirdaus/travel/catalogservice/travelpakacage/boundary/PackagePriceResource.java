package id.co.davidfirdaus.travel.catalogservice.travelpakacage.boundary;

import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.TravelPackage;
import lombok.extern.log4j.Log4j2;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Log4j2
@Path("packages/{packageId}/prices")
public class PackagePriceResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrices(@PathParam("packageId") Long packageId, @QueryParam("page") int page, @QueryParam("size") int size) {
        return Response.accepted().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrice(@PathParam("packageId") Long packageId, @PathParam("id") Long id) {
        return Response.accepted().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPrice(TravelPackage travelPackage) {
        return Response.accepted().build();
    }

    @POST
    @Path("/{id}/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePrice(@PathParam("id") Long id, TravelPackage travelPackage) {
        return Response.accepted().build();
    }

    @POST
    @Path("/{id}/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePrice(@PathParam("id") Long id) {
        return Response.accepted().build();
    }

}
