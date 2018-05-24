package com.epam.evgeniy_stepanov.java.lesson2;

public abstract class ElectricalAppliance implements IElectricalAppliance {
    boolean state;
    String name, origin, color, locationOfTheApartment;
    int power, length, width, height;

    public ElectricalAppliance(boolean state, String name, String origin, String color, String locationOfTheApartment, int power, int length, int width, int height) {
        this.state = state;
        this.name = name;
        this.origin = origin;
        this.color = color;
        this.locationOfTheApartment = locationOfTheApartment;
        this.power = power;
        this.length = length;
        this.width = width;
        this.height = height;
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
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
