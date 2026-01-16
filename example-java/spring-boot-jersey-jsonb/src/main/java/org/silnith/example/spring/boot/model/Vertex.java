package org.silnith.example.spring.boot.model;

public class Vertex {

    private double x;
    private double y;
    private double z;
    private double w;

    public Vertex() {
        this(0, 0, 0);
    }

    public Vertex(double x, double y, double z) {
        this(x, y, z, 1);
    }

    
    public Vertex(double x, double y, double z, double w) {
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
