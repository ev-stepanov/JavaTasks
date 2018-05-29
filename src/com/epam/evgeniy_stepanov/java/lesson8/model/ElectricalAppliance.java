package com.epam.evgeniy_stepanov.java.lesson8.model;

import com.epam.evgeniy_stepanov.java.lesson8.interfaces.IElectricalAppliance;

public abstract class ElectricalAppliance implements IElectricalAppliance {
    boolean state;
    String name, origin, color, locationOfTheApartment;
    int power;

    public ElectricalAppliance(boolean state, String name, String origin, String color, String locationOfTheApartment, int power) {
        this.state = state;
        this.name = name;
        this.origin = origin;
        this.color = color;
        this.locationOfTheApartment = locationOfTheApartment;
        this.power = power;
    }

    @Override
    public String toString() {
        return "ElectricalAppliance{" +
                "state=" + state +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", color='" + color + '\'' +
                ", locationOfTheApartment='" + locationOfTheApartment + '\'' +
                ", power=" + power +
                '}';
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLocationOfTheApartment() {
        return locationOfTheApartment;
    }

    public void setLocationOfTheApartment(String locationOfTheApartment) {
        this.locationOfTheApartment = locationOfTheApartment;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void On (ElectricalAppliance electricalAppliance)
    {
        electricalAppliance.setState(true);
    }

    @Override
    public void Off (ElectricalAppliance electricalAppliance)
    {
        electricalAppliance.setState(false);
    }
}
