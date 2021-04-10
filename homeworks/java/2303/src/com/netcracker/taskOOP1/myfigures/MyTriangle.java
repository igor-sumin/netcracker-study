package com.netcracker.taskOOP1.myfigures;

import com.netcracker.taskOOP1.Figure;

import java.lang.reflect.Type;

public class MyTriangle extends MyPoint implements Figure {
    private final MyPoint v1, v2, v3;

    public MyTriangle(int x1, int y1,
                      int x2, int y2,
                      int x3, int y3) {
        v1 = new MyPoint(x1, y1);
        v2 = new MyPoint(x2, y2);
        v3 = new MyPoint(x3, y3);
    }

    public MyTriangle(MyPoint mp1, MyPoint mp2, MyPoint mp3) {
        this(mp1.getX(), mp1.getY(),
             mp2.getX(), mp2.getY(),
             mp3.getX(), mp3.getY()
        );
    }

    public String toString() {
        return (
            "MyTriangle = { " +
            "v1 = " + v1.toString() + ", " +
            "v2 = " + v2.toString() + ", " +
            "v3 = " + v3.toString() + ", " +
            " }"
        );
    }

    public String getType() {
        int cnt = (v1.distance(v2) == v1.distance(v3) ? 1 : 0) +
                  (v1.distance(v2) == v2.distance(v3) ? 1 : 0) +
                  (v1.distance(v3) == v2.distance(v3) ? 1 : 0);

        return switch (cnt) {
            case 0, 1 -> TypeTriangle.SCALENE.nameLowerCase();
            case 2 -> TypeTriangle.ISOSCELES.nameLowerCase();
            case 3 -> TypeTriangle.EQUILATERAL.nameLowerCase();
            default -> throw new IllegalStateException("Unexpected value: " + cnt);
        };
    }

    @Override
    public double getArea() {
        // Стороны треугольника
        double a = v1.distance(v2);
        double b = v1.distance(v3);
        double c = v2.distance(v3);

        // Полупериметр
        double p = (a + b + c) / 2;

        // Формула Герона
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimeter() {
        return v1.distance(v2) + v1.distance(v3) + v2.distance(v3);
    }

    public static void main(String[] args) {
        System.out.println("--- 6. MyTriangle class ---");

        MyTriangle mt = new MyTriangle(
                new MyPoint(0, 1),
                new MyPoint(2, 3),
                new MyPoint(5, 5)
        );

        System.out.println(mt.toString());
        System.out.println(mt.getArea());
        System.out.println(mt.getPerimeter());
        System.out.println(mt.getType());

        System.out.println();
    }
}