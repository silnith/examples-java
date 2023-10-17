package org.silnith.example.spring.webmvc.controller;

import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
@RequestMapping(path = {"tessellate"})
public class TessellationController {

	@PostMapping
	public Iterable<?> tessellate(final Reader requestReader, final Writer responseWriter) {
		HttpEntity<Object> httpEntity;
		ResponseEntity<Object> responseEntity;
		ResponseBodyEmitter responseBodyEmitter;
		StreamingResponseBody streamingResponseBody;
		return new ArrayList<>();
	}

}
