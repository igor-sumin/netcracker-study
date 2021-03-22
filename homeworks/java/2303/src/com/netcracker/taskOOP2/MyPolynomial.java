package com.netcracker.taskOOP2;

import java.util.Arrays;

public class MyPolynomial {
    private final double[] coeffs;

    private String getTwoMembers() {
        // for cases of:
        // -2x + 4 or 3x - 1
        return (
            Math.abs(coeffs[1]) + "x " + (
                coeffs[0] != 0 ? (
                    coeffs[0] > 0 ? "+ " : "- "
                ) + Math.abs(coeffs[0]) : ""
            )
        );
    }

    public MyPolynomial() {
        this(new double[]{});
    }

    public MyPolynomial(double... coeffs) {
        this(0, coeffs.length, coeffs);
    }

    public MyPolynomial(int i, int len, double... coeffs) {
        this.coeffs = new double[coeffs.length];
        System.arraycopy(coeffs, 0, this.coeffs, i, len);
    }

    public void setMember(double member, int i) {
        this.coeffs[i] = member;
    }

    /** Get the degree of a polynomial */
    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        if (coeffs.length == 1) {
            return "" + coeffs[0];
        } else if (coeffs.length == 2) {
            return getTwoMembers();
        }

        StringBuilder result = new StringBuilder();
        boolean flag = true;

        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (coeffs[i] == 0) {
                continue;
            }

            if (!flag) {
                if (coeffs[i] > 0.) {
                    result.append(" + ");
                } else {
                    result.append(" - ");
                }
            }
            flag = false;

            result.append(Math.abs(coeffs[i]));
            if (i != 0) {
                result.append("x^").append(i);
            }
        }

        return result.toString();
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = coeffs.length - 1; i >= 0; i--) {
            result += coeffs[i] * Math.pow(x, i);
        }

        return result;
    }

    public MyPolynomial add(MyPolynomial op2) {
        int degreeThis = this.coeffs.length;
        int degreeOp2 = op2.coeffs.length;

        int minLength = Math.min(degreeThis, degreeOp2);
        int maxLength = Math.max(degreeThis, degreeOp2);

        MyPolynomial result = new MyPolynomial(new double[maxLength]);
        int i = 0;

        while (i < minLength) {
            result.setMember(this.coeffs[i] + op2.coeffs[i], i);
            i++;
        }

        while (i < degreeThis) {
            result.setMember(this.coeffs[i], i);
            i++;
        }

        while (i < degreeOp2) {
            result.setMember(op2.coeffs[i], i);
            i++;
        }

        return result;
    }

    public MyPolynomial multiply(MyPolynomial op2) {
        int degreeThis = this.coeffs.length;
        int degreeOp2 = op2.coeffs.length;

        MyPolynomial[] grid = new MyPolynomial[degreeThis];

        // Creating a grid of elements multiplied by each other in turn
        // Example:
        // [20, -15, -40,   5,   0, 0]
        // [0,   12,  -9, -24,   3, 0]
        // [0,    0,   8,  -6, -16, 2]
        //
        for (int i = 0; i < degreeThis; i++) {
            double[] temp = new double[degreeThis + degreeOp2 - 1];
            for (int j = 0; j < degreeOp2; j++) {
                temp[j] = this.coeffs[i] * op2.coeffs[j];
            }

            // Shift the elements depending on the degree of the polynomials
            grid[i] = new MyPolynomial(i, degreeOp2, temp);
        }

        // Summing up the shifted elements of the polynomials
        MyPolynomial result = new MyPolynomial();
        for (MyPolynomial polynomial : grid) {
            result = result.add(polynomial);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--- 2. MyPolynomial class ---");

        MyPolynomial mp1 = new MyPolynomial(new double[] {5, 3, 2});
        MyPolynomial mp2 = new MyPolynomial(new double[] {4, -3, -8, 1});

        System.out.println(mp1.getDegree());
        System.out.println(mp1.toString());
        System.out.println(mp2.toString());
        System.out.println(mp2.evaluate(1));

        System.out.println(mp1.add(mp2).toString());
        System.out.println(mp1.multiply(mp2).toString());
    }
}