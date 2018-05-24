package com.epam.evgeniy_stepanov.java.lesson5.model;

public class Flatiron extends ElectricalAppliance {
    int MaxTemperature;

    public Flatiron(boolean state, String name, String origin, String color, String locationOfTheApartment, int power, int length, int width, int height, int maxTemperature) {
        super(state, name, origin, color, locationOfTheApartment, power, length, width, height);
        MaxTemperature = maxTemperature;
    }
}
