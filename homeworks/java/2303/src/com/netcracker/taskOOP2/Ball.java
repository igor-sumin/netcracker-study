package com.netcracker.taskOOP2;

public class Ball {
    private double x, y;
    private int radius;
    private double xDelta, yDelta;

    public Ball() {
        this(0, 0, 1, 1, 90);
    }

    public Ball(double x, double y, int radius, int speed, int direction) throws ArithmeticException {
        if (direction > 180 || direction < -180) {
            throw new ArithmeticException("the direction is not located in [-180, 180] -> " + direction);
        }

        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = speed * Math.cos(direction);
        this.yDelta = (-1) * speed * Math.sin(direction);
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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getXDelta() {
        return xDelta;
    }

    public double getYDelta() {
        return yDelta;
    }

    public void move() {
        this.x += this.xDelta;
        this.y += this.yDelta;
    }

    public void reflectHorizontal() {
        this.xDelta *= (-1);
    }

    public void reflectVertical() {
        this.yDelta *= (-1);
    }

    @Override
    public String toString() {
        return "Ball = {(" + x + ", " + y + "), speed = " + xDelta + ", " + yDelta + ")}";
    }

    public static void main(String[] args) {
        System.out.println("--- 3. Ball class ---");
        Ball b = new Ball();
        System.out.println(b.toString());

        for (int i = 0; i < 4; i++) b.move();

        System.out.println(b.getX());
        b.reflectHorizontal();
        System.out.println(b.toString());

        Container c = new Container();
        System.out.println(c.collides(b));
        System.out.println(c.toString());
    }
}