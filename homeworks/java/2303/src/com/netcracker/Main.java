package com.netcracker;

import com.netcracker.taskOOP1.figures.Circle;
import com.netcracker.taskOOP1.figures.Rectangle;
import com.netcracker.taskOOP1.enterprise.Employee;
import com.netcracker.taskOOP1.enterprise.Book;
import com.netcracker.taskOOP1.myfigures.MyPoint;
import com.netcracker.taskOOP1.myfigures.MyTriangle;

import com.netcracker.taskOOP2.MyComplex;
import com.netcracker.taskOOP2.MyPolynomial;
import com.netcracker.taskOOP2.Ball;

/**
 * @author Igor Sumin
 */
public class Main {
    /**
     * The first part of the implementation of homework classes to 23.03.2021
     */
    public static void tasksOOP1(String[] args) {
        Circle.main(args);
        Rectangle.main(args);
        Employee.main(args);
        Book.main(args);
        MyPoint.main(args);
        MyTriangle.main(args);
    }

    /**
     * The second part of the implementation of homework classes to 23.03.2021
     */
    public static void tasksOOP2(String[] args) {
        MyComplex.main(args);
        MyPolynomial.main(args);
        Ball.main(args);
    }


    public static void main(String[] args) {
        System.out.println("------ First part ------" + '\n');
        Main.tasksOOP1(args);
        System.out.println("------ Second part ------" + '\n');
        Main.tasksOOP2(args);
    }
}