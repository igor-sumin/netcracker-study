package com.netcracker.chapters.first;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Solutions1 {
    public static void calcEx1() {
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("enter integer: ");
            int num = in.nextInt();

            System.out.println(Integer.toString(num, 2));       // binary
            System.out.println(Integer.toString(num, 8));       // octal
            System.out.println(Integer.toString(num, 16));      // hex
            System.out.printf("0x%08x\n", num);                      // reciprocal (?)

            System.out.print("repeat? y/n: ");
        } while (in.next().toLowerCase().startsWith("y"));
    }

    public static void calcEx2() {
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("enter angle: ");
            int angle = in.nextInt();

            // not working with negative numbers
            System.out.println(angle % 360);
            // working for any integers
            System.out.println(Math.floorMod(angle, 360));

            System.out.print("repeat? y/n: ");
        } while (in.next().toLowerCase().startsWith("y"));
    }

    public static void calcEx3() {
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("enter three integers: ");
            int[] nums = new int[3];
            for (int i = 0; i < 3; i++) {
                nums[i] = in.nextInt();
            }

            // 1 var
            if (nums[0] > nums[1]) {
                if (nums[0] > nums[2]) {
                    System.out.println("largest = " + nums[0]);
                } else {
                    System.out.println("largest = " + nums[2]);
                }
            } else {
                if (nums[1] > nums[2]) {
                    System.out.println("largest = " + nums[1]);
                } else {
                    System.out.println("largest = " + nums[2]);
                }
            }

            // 2 var
            System.out.println("largest = " + Arrays.stream(nums).max().getAsInt());

            System.out.print("repeat? y/n: ");
        } while (in.next().toLowerCase().startsWith("y"));
    }

    public static void calcEx4() {
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
    }

    private static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.valueOf(1))) {
            return new BigInteger("1");
        }

        return n.multiply(
            factorial(
                n.subtract(BigInteger.valueOf(1))
            )
        );
    }

    public static void calcEx6() {
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("enter n!: ");
            BigInteger n = new BigInteger(in.next());
            System.out.println(factorial(n));

            System.out.print("repeat? y/n: ");
        } while (in.next().toLowerCase().startsWith("y"));
    }

    private static int nextInt(Random generator, int low, int high) {
        return low + generator.nextInt(high - low);
    }

    private static ArrayList<Integer> lottery() {
        ArrayList<Integer> tickets = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Random randNum = new Random();
            int ticket = Solutions1.nextInt(randNum, 1, 49);

            if (tickets.contains(ticket)) {
                i--;
            } else {
                tickets.add(ticket);
            }
        }

        return tickets;
    }

    public static void calcEx13() {
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("lottery: ");
            System.out.println(lottery().toString());
            System.out.print("repeat? y/n: ");
        } while (in.next().toLowerCase().startsWith("y"));
    }

    public static void main(String[] args) {
        Solutions1.calcEx1();
        Solutions1.calcEx2();
        Solutions1.calcEx3();
        Solutions1.calcEx4();
        Solutions1.calcEx6();
        Solutions1.calcEx13();
    }
}