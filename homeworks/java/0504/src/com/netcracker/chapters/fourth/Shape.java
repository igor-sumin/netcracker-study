package com.netcracker.chapters.fourth;

import com.netcracker.chapters.second.Point;

public abstract class Shape implements Cloneable {
    protected Point center;

    public Shape(Point center) {
        this.center = new Point(center.getX(), center.getY());
    }

    public abstract Point getCenter();

    public void moveBy(double dx, double dy) {
        center.translate(dx, dy);
    }

    @Override
    public Shape clone() throws CloneNotSupportedException {
        return (Shape) super.clone();
    }
}