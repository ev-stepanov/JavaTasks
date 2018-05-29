package com.epam.evgeniy_stepanov.java.lesson8.model;

public class Kettle extends ElectricalAppliance {
    int boilingTime;

    public Kettle(boolean state, String name, String origin, String color, String locationOfTheApartment, int power) {
        super(state, name, origin, color, locationOfTheApartment, power);
        this.boilingTime = 2;
    }
}
