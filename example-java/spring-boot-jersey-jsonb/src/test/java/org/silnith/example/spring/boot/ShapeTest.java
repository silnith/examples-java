package org.silnith.example.spring.boot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import jakarta.inject.Inject;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShapeTest {

    @Inject
    TestRestTemplate restTemplate;

    @Test
    void testOctahedronAsObjects() {
        final RequestEntity<Void> request = RequestEntity
                .get("/shape/octahedron")
                .accept(MediaType.APPLICATION_JSON)
                .build();
        final ResponseEntity<String> response = restTemplate.exchange(request, String.class);

        final String responseBody = """
                [
                    {
                        "vertices":[
                            {"x":1.0,"y":0.0,"z":0.0,"w":1.0},
                            {"x":0.0,"y":0.0,"z":1.0,"w":1.0},
                            {"x":0.0,"y":1.0,"z":0.0,"w":1.0}
                        ]
                    },
                    {
                        "vertices":[
                            {"x":-1.0,"y":0.0,"z":0.0,"w":1.0},
                            {"x":0.0,"y":1.0,"z":0.0,"w":1.0},
                            {"x":0.0,"y":0.0,"z":1.0,"w":1.0}
                        ]
                    },
                    {
                        "vertices":[
                            {"x":1.0,"y":0.0,"z":0.0,"w":1.0},
                            {"x":0.0,"y":-1.0,"z":0.0,"w":1.0},
                            {"x":0.0,"y":0.0,"z":1.0,"w":1.0}
                        ]
                    },
                    {
                        "vertices":[
                            {"x":-1.0,"y":0.0,"z":0.0,"w":1.0},
                            {"x":0.0,"y":0.0,"z":1.0,"w":1.0},
                            {"x":0.0,"y":-1.0,"z":0.0,"w":1.0}
                        ]
                    },
                    {
                        "vertices":[
                            {"x":1.0,"y":0.0,"z":0.0,"w":1.0},
                            {"x":0.0,"y":1.0,"z":0.0,"w":1.0},
                            {"x":0.0,"y":0.0,"z":-1.0,"w":1.0}
                        ]
                    },
                    {
                        "vertices":[
                            {"x":-1.0,"y":0.0,"z":0.0,"w":1.0},
                            {"x":0.0,"y":0.0,"z":-1.0,"w":1.0},
                            {"x":0.0,"y":1.0,"z":0.0,"w":1.0}
                        ]
                    },
                    {
                        "vertices":[
                            {"x":1.0,"y":0.0,"z":0.0,"w":1.0},
                            {"x":0.0,"y":0.0,"z":-1.0,"w":1.0},
                            {"x":0.0,"y":-1.0,"z":0.0,"w":1.0}
                        ]
                    },
                    {
                        "vertices":[
                            {"x":-1.0,"y":0.0,"z":0.0,"w":1.0},
                            {"x":0.0,"y":-1.0,"z":0.0,"w":1.0},
                            {"x":0.0,"y":0.0,"z":-1.0,"w":1.0}
                        ]
                    }
                ]
                """.replaceAll("\\s", "");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseBody, response.getBody());
    }

}
