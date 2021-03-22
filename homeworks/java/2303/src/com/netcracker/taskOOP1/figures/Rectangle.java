package com.netcracker.taskOOP1.figures;

import com.netcracker.taskOOP1.Figure;

public class Rectangle implements Figure {
    private double length;
    private double width;

    public Rectangle() {
        this(1.0, 1.0);
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle = { length = " + length + ", width = " + width + " }";
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    public static void main(String[] args) {
        System.out.println("--- 2. Rectangle class ---");

        System.out.println("r1: ");
        Rectangle r = new Rectangle();
        System.out.println(r.toString());
        System.out.println(r.getArea());
        System.out.println(r.getPerimeter());

        System.out.println();

        System.out.println("r2: ");
        Rectangle c2 = new Rectangle(3.0, 4.0);
        System.out.println(c2.getWidth());
        System.out.println(c2.getLength());

        System.out.println();
    }
}