package com.epam.evgeniy_stepanov.java.lesson1.task2;

import java.util.*;


public class StringHandler {
    Scanner scan;
    List<String> strings;

    public static void main(String[] args) {
        new StringHandler().run();
    }

    void run() {
        scan = new Scanner(System.in);
        strings = new ArrayList<>();

        System.out.println("Enter number of task:");
        int numberOfTask = scan.nextInt();
        arrayFilling();
        switch (numberOfTask) {
            case 1: {
                minMaxStrings(strings);
                break;
            }

            case 2: {
                averageLengthMore(strings);
                break;
            }

            case 3: {
                averageLengthLess(strings);
                break;
            }


            case 4: {
                minCntSymbol(strings);
                break;
            }

            case 5: {
                cntSymbol(strings);
                break;
            }

            case 6: {
                wordsOfNumerals(strings);
                break;
            }
        }
    }

    void arrayFilling() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            strings.add(scan.nextLine());
        }
    }

    void minMaxStrings(List<String> strings) {
        String maxString = strings.get(0);
        String minString = strings.get(0);

        int maxLength = maxString.length();
        int minLength = minString.length();

        for (String s : strings) {
            if (s.length() < minLength) {
                minLength = s.length();
                maxString = s;
            }

            if (s.length() > maxLength) {
                maxLength = s.length();
                maxString = s;
            }
        }

        System.out.println(maxString + ": length - " + maxLength);
        System.out.println(minString + ": length - " + minLength);
    }

    void averageLengthMore(List<String> strings) {
        int averageLength = 0;
        for (int i = 0; i < strings.size(); i++) {
            averageLength += strings.get(i).length();
        }


        averageLength /= strings.size();
        System.out.println("Average length: " + averageLength);
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() > averageLength) {
                System.out.println(strings.get(i) + ": length - " + strings.get(i).length());
            }
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() < averageLength) {
                System.out.println(strings.get(i) + ": length - " + strings.get(i).length());
            }
        }
    }

    void averageLengthLess(List<String> strings) {
        int averageLength = 0;
        for (int i = 0; i < strings.size(); i++) {
            averageLength += strings.get(i).length();
        }


        averageLength /= strings.size();
        System.out.println("Average length: " + averageLength);
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() < averageLength) {
                System.out.println(strings.get(i) + ": length - " + strings.get(i).length());
            }
        }
    }

    void minCntSymbol(List<String> strings) {
        int countDifferentSymbols = Integer.MAX_VALUE;
        String answ = "";


        for (String s : strings) {
            Set<Character> symbols = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                symbols.add(s.charAt(i));
            }
            if (symbols.size() < countDifferentSymbols) {
                countDifferentSymbols = symbols.size();
                answ = s;
            }

        }

        System.out.println(answ);
    }

    void cntSymbol(List<String> strings) {
        for (String s : strings) {
            Set<Character> symbols = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                symbols.add(s.charAt(i));
            }
            if (symbols.size() == s.length()) {
                System.out.println(s);
                break;
            }
        }
    }

    void wordsOfNumerals(List<String> strings) {
        String answ = "";
        int cnt = 0;

        for (String s : strings) {
            List<Character> symbols = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                    symbols.add(s.charAt(i));
            }

            if (symbols.size() == s.length()) {
                if (cnt <= 1) {
                    answ = s;
                    cnt++;
                }
            }
        }

        System.out.println(answ);
    }
}