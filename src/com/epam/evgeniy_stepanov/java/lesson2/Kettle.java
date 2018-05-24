package com.epam.evgeniy_stepanov.java.lesson2;

public class Kettle extends ElectricalAppliance {
    int boilingTime;

    public Kettle(boolean state, String name, String origin, String color, String locationOfTheApartment, int power, int length, int width, int height, int boilingTime) {
        super(state, name, origin, color, locationOfTheApartment, power, length, width, height);
        this.boilingTime = boilingTime;
    }
}
