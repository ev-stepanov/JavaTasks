package com.epam.evgeniy_stepanov.java.lesson8.exceptions;

public class MinMaxException extends  Exception{
    public String message() {
        return "Minimum value greater than maximum.";
    }
}
