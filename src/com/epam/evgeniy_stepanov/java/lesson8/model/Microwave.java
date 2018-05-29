package com.epam.evgeniy_stepanov.java.lesson8.model;

public class Microwave extends ElectricalAppliance {
    int maximumHeatingTime;

    public Microwave(boolean state, String name, String origin, String color, String locationOfTheApartment, int power) {
        super(state, name, origin, color, locationOfTheApartment, power);
        this.maximumHeatingTime = 43;
    }
}
