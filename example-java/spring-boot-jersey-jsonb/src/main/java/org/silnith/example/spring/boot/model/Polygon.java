package org.silnith.example.spring.boot.model;

import java.util.List;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Polygon {
	
	private List<Vertex> vertices;

	public Polygon() {
		super();
	}

	@JsonbCreator
	public Polygon(@JsonbProperty("vertices") @NotNull @Size(min = 3) final List<@NotNull @Valid Vertex> vertices) {
		super();
		if (vertices == null) {
			throw new IllegalArgumentException("Vertices cannot be null.");
		}
		if (vertices.size() < 3) {
			throw new IllegalArgumentException("Polygon must have at least three vertices.");
		}
		this.vertices = vertices;
	}

	@JsonbProperty("vertices")
	@NotNull
	@Size(min = 3)
	public List<@NotNull @Valid Vertex> getVertices() {
		return vertices;
	}

	@JsonbProperty("vertices")
	public void setVertices(@NotNull @Size(min = 3) final List<@NotNull @Valid Vertex> vertices) {
		if (vertices == null) {
			throw new IllegalArgumentException("Vertices cannot be null.");
		}
		if (vertices.size() < 3) {
			throw new IllegalArgumentException("Polygon must have at least three vertices.");
		}
		this.vertices = vertices;
	}

}
