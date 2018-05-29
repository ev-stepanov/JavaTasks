package com.epam.evgeniy_stepanov.java.lesson7;

import com.epam.evgeniy_stepanov.java.lesson7.Interfaces.IEmployeeDAO;

import java.sql.*;
import java.util.ArrayList;

public class ImplementsEmploeeDAO implements IEmployeeDAO {
    ConnectionToBD connectionToBD = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;

    public ImplementsEmploeeDAO(ConnectionToBD connectionToBD) {
        this.connectionToBD = connectionToBD;
    }


    @Override
    public void insert(Employee employee) {
        try {
            Connection connection = ConnectionToBD.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO employees (firstname, lastname) " +
                    "VALUES(?, ?, ?, ?)");

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setInt(3, employee.getSalary());
            statement.setInt(4, employee.getWorkExperience());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Employee> selectAll() {
        Connection connection = ConnectionToBD.getConnection();
        ArrayList<Employee> employeeList = new ArrayList<>();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM employees";
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int salary = rs.getInt("salary");
                int workExperience = rs.getInt("workExperience");

                Employee employee = new Employee();
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setSalary(salary);
                employee.setWorkExperience(workExperience);

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}