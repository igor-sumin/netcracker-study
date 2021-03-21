/**
 * Created by Igor Sumin
 */

package com.netcracker;

import com.netcracker.figures.Circle;
import com.netcracker.figures.Rectangle;
import com.netcracker.enterprise.Employee;
import com.netcracker.enterprise.Book;
import com.netcracker.myfigures.MyPoint;
import com.netcracker.myfigures.MyTriangle;

public class Main {
    /**
     * The first part of the implementation of homework classes on 23.03.2021
     */
    public static void tasksOOP1(String[] args) {
        Circle.main(args);
        Rectangle.main(args);
        Employee.main(args);
        Book.main(args);
        MyPoint.main(args);
        MyTriangle.main(args);
    }

    public static void main(String[] args) {
        Main.tasksOOP1(args);
    }
}