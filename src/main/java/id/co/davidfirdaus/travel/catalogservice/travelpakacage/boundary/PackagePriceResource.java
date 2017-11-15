package id.co.davidfirdaus.travel.catalogservice.travelpakacage.boundary;

import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service.*;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.PriceDetail;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Log4j2
@Path("packages/{packageId}/prices")
public class PackagePriceResource {

    @Autowired
    GetPackagePriceBL getPackagePriceBL;

    @Autowired
    AddPackagePriceBL addPackagePriceBL;

    @Autowired
    UpdatePackagePriceBL updatePackagePriceBL;

    @Autowired
    DeletePackagePriceBL deletePackagePriceBL;

    @Autowired
    ValidateTravelPackageBL validateTravelPackageBL;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrices(@PathParam("packageId") Long packageId, @QueryParam("page") int page, @QueryParam("size") int size) {
        validateTravelPackageBL.validateTravelPackageExists(packageId);
        return Response.ok().entity(getPackagePriceBL.getTravelPackages(page, size)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrice(@PathParam("packageId") Long packageId, @PathParam("id") Long id) {
        validateTravelPackageBL.validateTravelPackageExists(packageId);
        return Response.ok(getPackagePriceBL.getTravelPackage(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPrice(@PathParam("packageId") Long packageId, PriceDetail priceDetail) {
        return Response.ok().entity(addPackagePriceBL.addPriceDetail(packageId, priceDetail)).build();
    }

    @POST
    @Path("/{id}/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePrice(@PathParam("packageId") Long packageId, @PathParam("id") Long id, PriceDetail priceDetail) {
        return Response.ok().entity(updatePackagePriceBL.updatePriceDetail(packageId, id, priceDetail)).build();
    }

    @POST
    @Path("/{id}/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePrice(@PathParam("packageId") Long packageId, @PathParam("id") Long id) {
        deletePackagePriceBL.deletePrice(packageId, id);
        return Response.ok().build();
    }

}
