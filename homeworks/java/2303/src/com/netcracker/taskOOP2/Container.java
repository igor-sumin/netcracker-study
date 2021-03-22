package com.netcracker.taskOOP2;

import com.netcracker.taskOOP2.Ball;
import com.netcracker.taskOOP2.Container;

/** Auxiliary class Container for testing the Ball class */
public class Container {
    private final int x1, x2;
    private final int y1, y2;

    public Container() {
        this(0, 0, 1600, 1200);
    }

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = width  + this.x1;
        this.y2 = height + this.y1;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return this.x2 - this.x1;
    }

    public int getHeight() {
        return this.y2 - this.y1;
    }

    public boolean collides(Ball ball) {
        double op2X = ball.getX();
        double op2Y = ball.getY();
        double op2Radius = ball.getRadius();

        return (
            (op2X - op2Radius) > this.x1         &&
            (op2X + op2Radius) < this.getWidth() &&
            (op2Y - op2Radius) > this.y1         &&
            (op2Y + op2Radius) < this.getHeight()
        );
    }

    @Override
    public String toString() {
        return "Container = {(" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + ")}";
    }
}