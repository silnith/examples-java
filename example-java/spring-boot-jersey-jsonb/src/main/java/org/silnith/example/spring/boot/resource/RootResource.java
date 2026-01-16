package org.silnith.example.spring.boot.resource;

import org.springframework.stereotype.Component;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Component
@Path("")
public class RootResource {

    @GET
    public Response getRoot() {
        return Response.ok("running", MediaType.TEXT_PLAIN_TYPE).build();
    }

}
