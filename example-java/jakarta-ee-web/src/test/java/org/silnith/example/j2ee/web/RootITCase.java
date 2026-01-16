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

class RootITCase {

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
    void testGetRoot() {
        try (final Response response = exampleAppTarget
                .request(MediaType.TEXT_PLAIN_TYPE)
                .get()) {
            assertEquals(Response.Status.OK, response.getStatusInfo().toEnum());
            final String body = response.readEntity(String.class);
            assertEquals("running", body);
        }
    }

}
