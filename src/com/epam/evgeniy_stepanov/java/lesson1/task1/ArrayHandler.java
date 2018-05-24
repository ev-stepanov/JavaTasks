package com.epam.evgeniy_stepanov.java.lesson1.task1;

import java.util.Scanner;

public class ArrayHandler {
    public static void main(String[] args) {
        new ArrayHandler().run();
    }
    public void run() {
        Scanner scan = new Scanner(System.in);

        int[] array = generateRandomArray();
        printArray(array);
        System.out.println("Enter task number");
        int numberOfTask = scan.nextInt();

        switch (numberOfTask){
            case 1: {
                replaceNegativeElementsWithZeros(array);
                printArray(array);
                break;
            }
            case 2: {
                System.out.println(sumOfElementsOnEvenPositions(array));
                break;
            }
            case 3: {
                swapMaxNegativeAndMinPositiveElements(array);
                printArray(array);
                break;
            }

            case 4: {
                triplePositiveElemetsInFrontOfNegativeElements(array);
                printArray(array);
                break;
            }

            case 5:{
                System.out.println(divBetweenMinElementAndAverage(array));
                break;
            }

            case 6: {
                printArray(array);
                break;
            }
        }
    }

    public int[] generateRandomArray() {
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = -10 + (int) (Math.random() * 20);
        }
        return  array;
    }

    public void printArray(int[] array){
        for (int i = 0; i  < array.length; i++){
            System.out.print(array[i] +  " ");
        }
        System.out.println();
    }

    public void swapMaxNegativeAndMinPositiveElements(int[] array){
        int minPositive = Integer.MAX_VALUE;
        int maxNegative = Integer.MIN_VALUE;
        int maxNegativeIndex = 0;
        int minPositiveIndex = 0;

        for (int i = 0; i  < array.length; i++){
            if (array[i]  < 0 && array[i] > maxNegative){
                maxNegative = array[i];
                maxNegativeIndex = i;
            }

            if (array[i] > 0 && array[i] < minPositive){
                minPositive = array[i];
                minPositiveIndex = i;
            }
        }

        array[maxNegativeIndex] = minPositive;
        array[minPositiveIndex] = maxNegative;
    }


    public int sumOfElementsOnEvenPositions(int[] mas){
        int sum = 0;
        for (int i = 0; i  < mas.length; i++) {
            if (i % 2 == 0) {
                sum += mas[i];
            }
        }
        return sum;
    }
    public void replaceNegativeElementsWithZeros(int[] mas){
        for (int i = 0; i < mas.length; i++){
            if (mas[i]  < 0){
                mas[i] = 0;
            }
        }
    }

    public void triplePositiveElemetsInFrontOfNegativeElements(int[] mas){
        for (int i = 0; i  < mas.length - 1; i++){
            if (mas[i + 1]  < 0){
                mas[i] *= 3;
            }
        }
    }

    public int divBetweenMinElementAndAverage(int[] mas){
        int minElement = Integer.MAX_VALUE;
        int average = 0;
        for (int i = 0; i  < mas.length; i++){
            if (mas[i]  == 0 && mas[i] <  minElement){
                minElement = mas[i];
            }
            average += mas[i];
        }

        return (average / 20) - minElement;
    }

    public void printElementsThatOccurMoreOne(int[] a){
        boolean[] used = new boolean[40];

        for (int i = 0; i < a.length; i += 2){
            for (int j = 0; j < a.length; j++){
                if (i != j && a[i] == a[j] && used[a[i] + 20] == false){
                    used[i] = true;
                    System.out.println(a[i]);
                    break;
                }
            }
        }
    }

}
