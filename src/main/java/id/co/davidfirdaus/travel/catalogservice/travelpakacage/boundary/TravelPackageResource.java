package id.co.davidfirdaus.travel.catalogservice.travelpakacage.boundary;

import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service.AddTravelPackageBL;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service.GetTravelPackageBL;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.control.service.UpdateTravelPackageBL;
import id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity.TravelPackage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Log4j2
@Path("packages")
public class TravelPackageResource {
    @Autowired
    GetTravelPackageBL getTravelPackageBL;

    @Autowired
    AddTravelPackageBL addTravelPackageBL;

    @Autowired
    UpdateTravelPackageBL updateTravelPackageBL;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTravelPackages(@QueryParam("page") int page, @QueryParam("size") int size) {
        return Response.ok().entity(getTravelPackageBL.getTravelPackages(page, size)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTravelPackage(@PathParam("id") Long id) {
        return Response.ok().entity(getTravelPackageBL.getTravelPackage(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTravelPackage(TravelPackage travelPackage) {
        return Response.ok().entity(addTravelPackageBL.addTravelPackage(travelPackage)).build();
    }
    @POST
    @Path("/{id}/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTravelPackage(@PathParam("id") Long id, TravelPackage travelPackage) {
        return Response.ok().entity(updateTravelPackageBL.updateTravelPackage(id, travelPackage)).build();
    }
}
