package com.netcracker.chapters.fourth;

import com.netcracker.chapters.second.Point;

import java.util.Arrays;

public class Solutions4 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Point[] dist = new Point[] {
               new Point(0, 0),
               new Point(2, 2)
        };
        System.out.println(Arrays.toString(dist));

        Circle circle = new Circle(dist[0], 5);
        System.out.println(circle.getCenter());

        Line line = new Line(dist);
        System.out.println(line.toString());

        Rectangle rectangle = new Rectangle(dist[1], 4, 4);
        Rectangle rectangleClone = rectangle.clone();
        System.out.println(rectangle.toString());
        System.out.println(rectangleClone.toString());

    }
}