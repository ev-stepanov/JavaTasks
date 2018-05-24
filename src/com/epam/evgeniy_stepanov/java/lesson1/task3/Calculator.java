package com.epam.evgeniy_stepanov.java.lesson1.task3;

import java.util.Scanner;
import static java.lang.System.exit;

public class Calculator {
    public int A;
    public int B;
    public String a;
    public String b;
    public float result;
    public int index;

    public static void main(String[] args) {
        new Calculator().runApplication();
    }

    public void runApplication() {
        readInput();
        selectAction();
        System.out.println(result);
    }

    public void readInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input A:");
        a = scanner.nextLine();
        if (isNumeric(a,A)) {
            A = Integer.parseInt(a);
            System.out.println("Please input B:");
            b = scanner.nextLine();
            if (isNumeric(b,B)) {
                B = Integer.parseInt(b);
                System.out.println("Please select operation:");
                System.out.println("1: A + B");
                System.out.println("2: A - B");
                System.out.println("3: A * B");
                System.out.println("4: A / B");
                index = scanner.nextInt();
            }
            else {
                System.out.println("B is not a number, closing...");
                exit(0);
            }
        }
        else {
            System.out.println("A is not a number, closing...");
            exit(0);
        }
    }

    public boolean isNumeric(String str, int num)
    {
        try {
            num = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void selectAction() {
        if (index >= 1 && index <= 4) {
            switch (index) {
                case 1: add();
                    break;
                case 2: subtract();
                    break;
                case 3: multiply();
                    break;
                case 4: divide();
                    break;
            }
        }
        else {
            System.out.println("Incorrect operation selected, closing...");
            exit(0);
        }
    }

    public void add() {
        result = A + B;
        System.out.println(A + " + " + B + " = " + result);
    }

    public void subtract() {
        result = A - B;
        System.out.println(A + " - " + B + " = " + result);
    }

    public void multiply() {
        result = A * B;
        System.out.println(A + " * " + B + " = " + result);
    }

    public void divide() {
        try {
            result = (float) A / B;
        }
        catch (ArithmeticException e) {
            System.out.println("Zero division exception");
        }
        System.out.println(A + " / " + B + " = " + result);
    }
}