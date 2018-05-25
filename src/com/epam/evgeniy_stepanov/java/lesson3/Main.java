package com.epam.evgeniy_stepanov.java.lesson3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Course> coursesStudent1 = new ArrayList<>();
        List<Course> coursesStudent2 = new ArrayList<>();

        Course course1 = new Course("Java Servlets", 16);
        Course course2 = new Course("Struts Frameworks", 24);
        Course course3 = new Course("Java Technologies Overview", 24);
        Course course4 = new Course("JFS/Swing", 24);
        Course course5 = new Course("JDBC", 24);

        coursesStudent1.add(course1);
        coursesStudent1.add(course2);

        Program program1 = new Program(LocalDateTime.of(2018, 3, 25, 15, 0), coursesStudent1, "Java Developer");

        coursesStudent2.add(course3);
        coursesStudent2.add(course4);
        coursesStudent2.add(course5);

        Program program2 = new Program(LocalDateTime.of(2018, 8, 13, 8, 0), coursesStudent2, "J2EE Developer");

        Student student1 = new Student("Ivanov", "Ivan", program1);
        Student student2 = new Student("Petrov", "Petr", program2);


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n)
        {
            case 1: {
                System.out.println(student1.getFirstName() + " " + student1.getLastName() + " (" + student1.getProgram().getCurriculum() + ") - " + student1.getProgramTimeLeft());
                System.out.println(student2.getFirstName() + " " + student2.getLastName() + " (" + student2.getProgram().getCurriculum() + ") - " + student2.getProgramTimeLeft());
                break;
            }
            case 2: {
                student1.printInfoStudent();
                student2.printInfoStudent();
                break;
            }
            default: {
                System.out.println("Invalid input!!!");
            }
        }
    }
}
