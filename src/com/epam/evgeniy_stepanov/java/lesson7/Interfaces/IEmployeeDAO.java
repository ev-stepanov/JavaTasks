package com.epam.evgeniy_stepanov.java.lesson7.Interfaces;

import com.epam.evgeniy_stepanov.java.lesson7.Employee;

import java.util.ArrayList;

public interface IEmployeeDAO {
    public void insert(Employee employee);
    public ArrayList<Employee> selectAll ();
}
