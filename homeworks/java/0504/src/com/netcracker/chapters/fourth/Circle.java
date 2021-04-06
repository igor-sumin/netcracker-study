package com.netcracker.chapters.fourth;

import com.netcracker.chapters.second.Point;

public class Circle extends Shape {
    private final double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public Point getCenter() {
        return this.center;
    }

    @Override
    public Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }

    @Override
    public String toString() {
        return (
            "Circle = ( " +
                "radius = "  + radius + ", " +
                "center = "  + center +
            " )"
        );
    }

}