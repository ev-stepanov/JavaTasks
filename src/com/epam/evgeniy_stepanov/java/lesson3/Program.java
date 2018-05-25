package com.epam.evgeniy_stepanov.java.lesson3;

import java.time.LocalDateTime;
import java.util.List;

public class Program {
    private LocalDateTime startDate;
    private List<Course> courses;
    private String curriculum;

    public Program(LocalDateTime startDate, List<Course> courses, String curriculum) {
        this.startDate = startDate;
        this.courses = courses;
        this.curriculum = curriculum;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public int getProgramDuration() {
        int sum = 0;
        for (Course course : courses) {
            sum += course.getDuration().intValue();
        }

        return sum;
    }
}
