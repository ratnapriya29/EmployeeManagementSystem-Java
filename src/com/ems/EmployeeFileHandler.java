package com.ems;

import java.io.*;
import java.util.ArrayList;

public class EmployeeFileHandler {

    private static final String FILE_NAME = "data/employees.dat";

    public static void saveEmployees(ArrayList<Employee> employees) {

        try (ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(employees);
            System.out.println("Employee data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Employee> loadEmployees() {

        ArrayList<Employee> employees = new ArrayList<>();

        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            employees = (ArrayList<Employee>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found.");
        }

        return employees;
    }
}