package org.silnith.example.j2ee.web;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.silnith.example.j2ee.web.model.Polygon;
import org.silnith.example.j2ee.web.model.Vertex;

class ExampleApplicationITCase {
	
	static Client client;

	WebTarget webappTarget;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		client = ClientBuilder.newClient();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		client.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		//webappTarget = client.target("http://localhost:8080/jakarta-ee-web-0.0.1-SNAPSHOT");
		webappTarget = client.target("http://localhost:8080/jakarta-ee-web");
	}

	@AfterEach
	void tearDown() throws Exception {
		webappTarget = null;
	}

	@Test
	void testGet() {
		try (final Response response = webappTarget
				.path("example")
				.path("tessellate")
				.request(MediaType.TEXT_PLAIN_TYPE)
				.get()) {
			assertEquals(Response.Status.OK, response.getStatusInfo().toEnum());
		}
	}

	@Test
	void testGetClasses() {
		final Entity<List<?>> requestEntity = Entity.json(Collections.emptyList());
		try (final Response response = webappTarget
				.path("example")
				.path("tessellate")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.post(requestEntity)) {
			assertEquals(Response.Status.OK, response.getStatusInfo().toEnum());
		}
	}

	@Test
	void testGetClasses2() {
		final Polygon square = new Polygon(Arrays.asList(new Vertex(0, 0, 0, 1), new Vertex(0, 1, 0, 1), new Vertex(1, 1, 0, 1), new Vertex(1, 0, 0, 1)));
		final Entity<List<?>> requestEntity = Entity.json(Collections.singletonList(square));
		try (final Response response = webappTarget
				.path("example")
				.path("tessellate")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.post(requestEntity)) {
			assertEquals(Response.Status.OK, response.getStatusInfo().toEnum());
		}
	}

}
