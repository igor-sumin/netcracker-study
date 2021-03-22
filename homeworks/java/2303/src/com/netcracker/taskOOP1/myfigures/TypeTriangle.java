package com.netcracker.taskOOP1.myfigures;

public enum TypeTriangle {
    Scalene, Isosceles, Equilateral;

    private static final TypeTriangle[] VAL = values();

    public static TypeTriangle getType(MyPoint v1, MyPoint v2, MyPoint v3) {
        int cnt = (v1.distance(v2) == v1.distance(v3) ? 1 : 0) +
                (v1.distance(v2) == v2.distance(v3) ? 1 : 0) +
                (v1.distance(v3) == v2.distance(v3) ? 1 : 0);

        return switch (cnt) {
            case 0, 1 -> Scalene;
            case 2 -> Isosceles;
            case 3 -> Equilateral;
            default -> throw new IllegalStateException("Unexpected value: " + cnt);
        };
    }
}