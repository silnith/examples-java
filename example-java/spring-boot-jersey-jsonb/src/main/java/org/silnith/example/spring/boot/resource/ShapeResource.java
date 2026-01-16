package org.silnith.example.spring.boot.resource;

import java.util.Arrays;
import java.util.List;

import org.silnith.example.spring.boot.model.Polygon;
import org.silnith.example.spring.boot.model.Vertex;
import org.springframework.stereotype.Component;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Component
@Path("shape")
public class ShapeResource {

    private static final List<Vertex> vertices = Arrays.asList(
            new Vertex(1, 0, 0),
            new Vertex(-1, 0, 0),
            new Vertex(0, 1, 0),
            new Vertex(0, -1, 0),
            new Vertex(0, 0, 1),
            new Vertex(0, 0, -1));

    private static final List<Polygon> polygons = Arrays.asList(
            new Polygon(Arrays.asList(vertices.get(0), vertices.get(4), vertices.get(2))),
            new Polygon(Arrays.asList(vertices.get(1), vertices.get(2), vertices.get(4))),
            new Polygon(Arrays.asList(vertices.get(0), vertices.get(3), vertices.get(4))),
            new Polygon(Arrays.asList(vertices.get(1), vertices.get(4), vertices.get(3))),
            new Polygon(Arrays.asList(vertices.get(0), vertices.get(2), vertices.get(5))),
            new Polygon(Arrays.asList(vertices.get(1), vertices.get(5), vertices.get(2))),
            new Polygon(Arrays.asList(vertices.get(0), vertices.get(5), vertices.get(3))),
            new Polygon(Arrays.asList(vertices.get(1), vertices.get(3), vertices.get(5))));

    @GET
    @Path("octahedron")
    public List<Polygon> produceOctahedron() {
        return polygons;
    }

}
