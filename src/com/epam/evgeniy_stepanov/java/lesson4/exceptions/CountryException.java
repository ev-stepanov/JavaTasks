package com.epam.evgeniy_stepanov.java.lesson4.exceptions;

public class CountryException extends Exception {
    public String message() {
        return  "The string of country is empty.";
    }
}
