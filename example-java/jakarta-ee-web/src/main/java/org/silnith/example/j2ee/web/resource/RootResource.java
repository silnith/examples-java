package org.silnith.example.j2ee.web.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class RootResource {

	@GET
	public Response getRoot() {
		return Response.ok("something", MediaType.TEXT_PLAIN_TYPE).build();
	}

}
