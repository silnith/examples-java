package org.silnith.example.j2ee.web.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Tessellator {

	@NotEmpty
	public List<@NotNull @Valid Polygon> convertToTriangleFan(@NotNull @Valid final Polygon polygon) {
		if (polygon == null) {
			throw new IllegalArgumentException("Polygon cannot be null.");
		}
		final List<Vertex> vertices = polygon.getVertices();
		if (vertices.size() < 3) {
			throw new IllegalArgumentException("Polygon must have at least three vertices.");
		}
		assert vertices.size() >= 3;
		final Iterator<Vertex> iterator = vertices.iterator();
		assert iterator.hasNext();
		final Vertex firstVertex = iterator.next();
		final List<Polygon> triangles = new ArrayList<>(vertices.size() - 2);
		
		assert iterator.hasNext();
		Vertex secondVertex = iterator.next();
		while (iterator.hasNext()) {
			final Vertex thirdVertex = iterator.next();
			
			final List<Vertex> triangleVertices = Arrays.asList(firstVertex, secondVertex, thirdVertex);
			final Polygon triangle = new Polygon(triangleVertices);
			triangles.add(triangle);
			
			secondVertex = thirdVertex;
		}
		return triangles;
	}

}
