package com.netcracker.chapters.fourth;

import com.netcracker.chapters.second.Point;

public class Rectangle extends Shape {
    private final double width, height;

    public Rectangle(Point topLeft, double width, double height) {
        super(new Point(topLeft.getX() + width / 2, topLeft.getY() + height / 2));
        this.width  = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public Point getCenter() {
        return this.center;
    }

    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone();
    }

    @Override
    public String toString() {
        return (
            "Rectangle = ( " +
                "width = "   + width + ", " +
                "height = "  + height +
            " )"
        );
    }
}