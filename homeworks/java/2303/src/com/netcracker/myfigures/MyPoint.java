package com.netcracker.myfigures;

import java.util.Arrays;

public class MyPoint {
    private int x, y;

    public MyPoint() {
        this(0, 0);
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY() {
        return new int[] {x, y};
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(MyPoint mp) {
        this.x = mp.x;
        this.y = mp.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /** Distance from this point to the given point at (x, y) */
    public double distance(int x, int y) {
        int a = (this.x - x);
        int b = (this.y - y);

        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    /** Distance from this point to the given instance of MyPoint */
    public double distance(MyPoint op2) {
        int a = (this.x - op2.x);
        int b = (this.y - op2.y);

        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    /** Distance from this point to (0, 0) */
    public double distance() {
        return this.distance(0, 0);
    }

    public static void main(String[] args) {
        System.out.println("--- 5. MyPoint class ---");

        System.out.println("mp1: ");
        MyPoint mp = new MyPoint(1, 1);
        System.out.println(mp.toString());
        System.out.println(mp.getX());
        System.out.println(Arrays.toString(mp.getXY()));

        System.out.println();

        System.out.println("mp2: ");
        MyPoint mp2 = new MyPoint(0, 4);
        mp2.setX(4);
        System.out.println(mp2.getX());

        double dis = mp.distance(mp2);
        System.out.println(dis);

        System.out.println();
    }

}