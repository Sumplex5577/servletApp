package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    //    public static void main(String[] args) {
    //        getConnection();
    //
    //        Employee employee = new Employee();
    //
    //        employee.setName("oleg");
    //        employee.setEmail(" ");
    //        employee.setCountry(" ");
    //        save(employee);
    //    }


    public static Connection getConnection() {

        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/employee";
        String user = "postgres";
        String password = "postgres";

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
        return connection;
    }

    public static int save(Employee employee) {
        int status = 0;
        try {
            Connection connection = EmployeeRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into watches(watchbrand,watchmodel,price,year) values (?,?,?,?)");
            ps.setString(1, employee.getWatchbrand());
            ps.setString(2, employee.getWatchmodel());
            ps.setString(3, employee.getPrice());
            ps.setString(4, employee.getYear());




            status = ps.executeUpdate();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int update(Employee employee) {

        int status = 0;

        try {
            Connection connection = EmployeeRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("update watches set watchbrand=?,watchmodel=?,price=?,year=? where id=?");
            ps.setString(1, employee.getWatchbrand());
            ps.setString(2, employee.getWatchmodel());
            ps.setString(3, employee.getPrice());
            ps.setString(4, employee.getYear());
            ps.setInt(7, employee.getId());

            status = ps.executeUpdate();
            connection.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return status;
    }

    public static int delete(int id) {

        int status = 0;

        try {
            Connection connection = EmployeeRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from watches where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            connection.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return status;
    }

    public static Employee getEmployeeById(int id) {

        Employee employee = new Employee();

        try {
            Connection connection = EmployeeRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from watches where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee.setId(rs.getInt(1));
                employee.setWatchbrand(rs.getString(2));
                employee.setWatchmodel(rs.getString(3));
                employee.setPrice(rs.getString(4));
                employee.setYear(rs.getString(5));

            }
            connection.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return employee;
    }

    public static List<Employee> getAllEmployees() {

        List<Employee> listEmployees = new ArrayList<>();

        try {
            Connection connection = EmployeeRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from watches");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Employee employee = new Employee();

                employee.setId(rs.getInt(1));
                employee.setWatchbrand(rs.getString(2));
                employee.setWatchmodel(rs.getString(3));
                employee.setPrice(rs.getString(4));
                employee.setYear(rs.getString(5));


                listEmployees.add(employee);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEmployees;
    }
}
