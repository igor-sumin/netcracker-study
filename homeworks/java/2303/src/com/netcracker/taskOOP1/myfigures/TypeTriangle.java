package com.netcracker.taskOOP1.myfigures;

public enum TypeTriangle {
    SCALENE, ISOSCELES, EQUILATERAL;

    private static final TypeTriangle[] VAL = values();

    public String nameLowerCase() {
        return name().toLowerCase();
    }
}