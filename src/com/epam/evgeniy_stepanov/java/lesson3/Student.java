package com.epam.evgeniy_stepanov.java.lesson3;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Student {
    private String firstName = null;
    private String lastName = null;
    private Program program = null;

    public Student(String firstName, String lastName, Program program) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.program = program;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Program getProgram() {
        return program;
    }

    public String getProgramTimeLeft() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime programLeft = program.getStartDate().plusDays(program.getProgramDuration() / 8);
        if (ChronoUnit.DAYS.between(now, programLeft) > 0) {
            return "Program left throw " + ChronoUnit.DAYS.between(now, programLeft) + " days " +
                    (ChronoUnit.HOURS.between(now, programLeft) % 24) + " hours!";
        }

        return "Program left " + ChronoUnit.DAYS.between(programLeft, now) + " days " +
                ChronoUnit.HOURS.between(programLeft, now) % 24 + " hours ago!";
    }

    public void printInfoStudent() {
        System.out.println(this.getFirstName() + " " + this.getLastName());
        Program program = this.getProgram();
        System.out.println(program.getStartDate());
        List<Course> courses1 = program.getCourses();
        for (Course course : courses1){
            System.out.println(course.getName() + " Duration: " + course.getDuration());
        }

        System.out.println("--------------------------------");
    }
}
