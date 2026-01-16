package org.silnith.example.j2ee.web.resource;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.StreamingOutput;

import org.silnith.example.j2ee.web.model.Polygon;
import org.silnith.example.j2ee.web.model.Tessellator;

@ApplicationScoped
@Path("tessellate")
public class TessellateResource {

    @NotNull
	private Tessellator tessellator;
	
	public TessellateResource() {
	    super();
	}

	@Inject
	public TessellateResource(final Tessellator tessellator) {
		super();
		this.tessellator = tessellator;
	}
	
	@POST
	public List<Polygon> tessellate(final List<Polygon> polygons) {
		final List<Polygon> triangles = new ArrayList<>();
		for (final Polygon polygon : polygons) {
			triangles.addAll(tessellator.convertToTriangleFan(polygon));
		}
		return triangles;
	}

//	@POST
//	@Consumes({MediaType.APPLICATION_JSON})
//	@Produces({MediaType.APPLICATION_JSON})
//	public StreamingOutput tessellate(final Reader reader) {
//		return new StreamingOutput() {
//
//			@Override
//			public void write(final OutputStream output) throws IOException, WebApplicationException {
//				try (final JsonParser parser = Json.createParser(reader)) {
//					while (parser.hasNext()) {
//						final JsonParser.Event event = parser.next();
//						switch (event) {
//						case START_ARRAY:
//							break;
//						default:
//							break;
//						}
//					}
//				}
//				try (final JsonGenerator generator = Json.createGenerator(output)) {
//					generator.writeStartArray();
//					generator.writeEnd();
//				}
//			}
//
//		};
//	}

}
