package id.co.davidfirdaus.travel.catalogservice.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Log4j2
@Provider
public class GenericExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        log.error(exception.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception.getMessage()).build();
    }
}