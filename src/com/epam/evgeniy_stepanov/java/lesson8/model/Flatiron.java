package com.epam.evgeniy_stepanov.java.lesson8.model;

public class Flatiron extends ElectricalAppliance {
    int MaxTemperature;

    public Flatiron(boolean state, String name, String origin, String color, String locationOfTheApartment, int power) {
        super(state, name, origin, color, locationOfTheApartment, power);
        MaxTemperature = 75;
    }
}
