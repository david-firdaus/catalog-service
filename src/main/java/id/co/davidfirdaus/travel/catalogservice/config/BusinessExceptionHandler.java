package id.co.davidfirdaus.travel.catalogservice.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import id.co.davidfirdaus.travel.catalogservice.commons.exception.BusinessException;
import lombok.extern.log4j.Log4j2;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Log4j2
@Provider
public class BusinessExceptionHandler implements ExceptionMapper<BusinessException> {

    @Override
    public Response toResponse(BusinessException exception) {
        log.error(exception.getMessage());
        final JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode objectNode = factory.objectNode()
                .put("field", exception.getCode())
                .put("description", exception.getDescription());

        return Response.status(Response.Status.BAD_REQUEST).entity(objectNode).build();
    }
}