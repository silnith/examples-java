package org.silnith.example.spring.boot;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.inject.Inject;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
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
	@Disabled
	void testEmpty() {
		final RequestEntity<Object> request = RequestEntity.post("/tessellate")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.body("[]");
		final ResponseEntity<String> response = restTemplate.exchange(request, String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("[]", response.getBody());
	}

	@Test
	@Disabled
	void testQuad() {
		final RequestEntity<Object> request = RequestEntity.post("/tessellate")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.body("[[[0,0][1,0][1,1][0,1]]]");
		final ResponseEntity<String> response = restTemplate.exchange(request, String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("[[[0,0][1,0][1,1]][[0,0][1,1][0,1]]]", response.getBody());
	}

}
