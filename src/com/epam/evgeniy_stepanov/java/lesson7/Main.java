package com.epam.evgeniy_stepanov.java.lesson7;

import com.epam.evgeniy_stepanov.java.lesson7.Interfaces.IEmployeeDAO;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ConnectionToBD connectionToBD = new ConnectionToBD();
        connectionToBD.process("jdbc:mysql://localhost:3306/employees", "StepanovEA", "BWiodfd38");
        
        IEmployeeDAO iEmployeeDAO = new ImplementsEmploeeDAO(connectionToBD);
        ArrayList<Employee> employees = iEmployeeDAO.selectAll();

        for (Employee employee: employees) {
            for (int i = 0; i < 15; i++) {
                iEmployeeDAO.insert(employee);
            }
        }

        connectionToBD.close();
    }
}
