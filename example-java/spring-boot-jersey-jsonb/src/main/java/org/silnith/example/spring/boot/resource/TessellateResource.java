package org.silnith.example.spring.boot.resource;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.StreamingOutput;

@Path("tessellate")
public class TessellateResource {

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public StreamingOutput tessellate(final Reader reader) {
		return new StreamingOutput() {

			@Override
			public void write(final OutputStream output) throws IOException, WebApplicationException {
				try (final JsonParser parser = Json.createParser(reader)) {
					while (parser.hasNext()) {
						final JsonParser.Event event = parser.next();
						switch (event) {
						case START_ARRAY:
							break;
						default:
							break;
						}
					}
				}
				try (final JsonGenerator generator = Json.createGenerator(output)) {
					generator.writeStartArray();
					generator.writeEnd();
				}
			}

		};
	}

}
