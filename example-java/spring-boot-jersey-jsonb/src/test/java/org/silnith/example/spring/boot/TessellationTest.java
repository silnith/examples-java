package org.silnith.example.spring.boot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.regex.Pattern;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import jakarta.inject.Inject;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TessellationTest {

    @Inject
    TestRestTemplate restTemplate;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testEmpty() {
        final RequestEntity<Object> request = RequestEntity
                .post("/tessellate")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body("[]");
        final ResponseEntity<String> response = restTemplate.exchange(request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("[]", response.getBody());
    }

    @Test
    @Disabled
    void testQuadAsArray() {
        final RequestEntity<Object> request = RequestEntity
                .post("/tessellate")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body("[[[0,0][1,0][1,1][0,1]]]");
        final ResponseEntity<String> response = restTemplate.exchange(request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("[[[0,0][1,0][1,1]][[0,0][1,1][0,1]]]", response.getBody());
    }

    @Test
    void testQuadAsObjects() {
        final String requestBody = """
                [
                    {
                        "vertices":[
                            {"x":0,"y":0},
                            {"x":1,"y":0},
                            {"x":1,"y":1},
                            {"x":0,"y":1}
                        ]
                    }
                ]
                """.replaceAll("\\s", "");
        Pattern.compile("\\s");
        final RequestEntity<Object> request = RequestEntity
                .post("/tessellate")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestBody);
        final ResponseEntity<String> response = restTemplate.exchange(request, String.class);

        final String responseBody = """
                [
                    {
                        "vertices":[
                            {"x":0.0,"y":0.0,"z":0.0,"w":1.0},
                            {"x":1.0,"y":0.0,"z":0.0,"w":1.0},
                            {"x":1.0,"y":1.0,"z":0.0,"w":1.0}
                        ]
                    },
                    {
                        "vertices":[
                            {"x":0.0,"y":0.0,"z":0.0,"w":1.0},
                            {"x":1.0,"y":1.0,"z":0.0,"w":1.0},
                            {"x":0.0,"y":1.0,"z":0.0,"w":1.0}
                        ]
                    }
                ]
                """.replaceAll("\\s", "");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseBody, response.getBody());
    }

}
