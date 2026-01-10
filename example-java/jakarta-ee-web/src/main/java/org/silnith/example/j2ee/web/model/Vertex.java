package org.silnith.example.j2ee.web.model;

import java.beans.ConstructorProperties;

import jakarta.json.bind.annotation.JsonbProperty;

public class Vertex {

	private double x, y, z, w;

	public Vertex() {
		super();
	}

	@ConstructorProperties({"x", "y", "z", "w"})
	public Vertex(
			@JsonbProperty("x") double x,
			@JsonbProperty("y") double y,
			@JsonbProperty("z") double z,
			@JsonbProperty("w") double w) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

}
