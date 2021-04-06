package com.netcracker.chapters.fourth;

import com.netcracker.chapters.second.Point;

public class Line extends Shape {
    private final Point from, to;

    public Line(Point[] points) {
        this(points[0], points[1]);
    }

    public Line(Point from, Point to) {
        super(new Point((from.getX() + to.getX()) / 2, (from.getY() + to.getY()) / 2));
        this.from = new Point(from.getX(), from.getY());
        this.to = new Point(to.getX(), to.getY());
    }

    @Override
    public Point getCenter() {
        return this.center;
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        return (Line) super.clone();
    }

    @Override
    public String toString() {
        return (
            "Line = ( " +
                "from = " + from + ", " +
                "center = "  + center + ", " +
                "to = " + to +
            " )"
        );
    }
}