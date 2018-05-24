package com.epam.evgeniy_stepanov.java.lesson2;

public class Microwave extends ElectricalAppliance {
    int maximumHeatingTime;

    public Microwave(boolean state, String name, String origin, String color, String locationOfTheApartment, int power, int length, int width, int height, int maximumHeatingTime) {
        super(state, name, origin, color, locationOfTheApartment, power, length, width, height);
        this.maximumHeatingTime = maximumHeatingTime;
    }
}
