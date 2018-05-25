package com.epam.evgeniy_stepanov.java.lesson3;

public class Course {
    private String name;
    private Number duration;

    public Course(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public Number getDuration() {
        return duration;
    }
}
