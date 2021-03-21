package com.netcracker.figures;

import com.netcracker.Figure;

public class Circle implements Figure {
    private double radius;
    private String color;

    public Circle() {
        this(1.0, "red");
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle(double radius) {
        this(radius, "red");
    }

    public Circle(String color) {
        this(1.0, color);
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle = { radius = " + radius + ", color = " + color + " }";
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {
        System.out.println("--- 1. Circle class ---");

        System.out.println("c1: ");
        Circle c = new Circle();
        System.out.println(c.toString());
        System.out.println(c.getArea());
        System.out.println(c.getPerimeter());

        System.out.println();

        System.out.println("c2: ");
        Circle c2 = new Circle(3, "black");
        System.out.println(c2.getColor());
        System.out.println(c2.getRadius());

        System.out.println();
    }
}