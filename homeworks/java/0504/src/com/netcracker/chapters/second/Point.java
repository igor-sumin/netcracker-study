package com.netcracker.chapters.second;

/**
 * Solution for chapter 2, exercise №5
 */
public final class Point {
    //
    private final double x, y;

    Point() {
        this(0., 0.);
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public Point translate(double x, double y) {
        return new Point(this.getX() + x, this.getY() + y);
    }

    public Point scale(double val) {
        return new Point(this.getX() * val, this.getY() * val);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        Point p = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println(p.toString());
    }
}