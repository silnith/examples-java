package org.silnith.example.j2ee.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

class ShapeITCase {

    static Client client;

    WebTarget webappTarget;
    WebTarget exampleAppTarget;

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
        webappTarget = client.target("http://localhost:8080/jakarta-ee-web");
        exampleAppTarget = webappTarget.path("example");
    }

    @AfterEach
    void tearDown() throws Exception {
        exampleAppTarget = null;
        webappTarget = null;
    }

    @Test
    void testGetShapeOctahedron() {
        try (final Response response = exampleAppTarget
                .path("shape")
                .path("octahedron")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get()) {
            assertEquals(Response.Status.OK, response.getStatusInfo().toEnum());
        }
    }

}
