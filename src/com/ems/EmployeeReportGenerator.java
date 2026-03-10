package com.ems;
import java.util.*;

public class EmployeeReportGenerator {

    public static void generateSalaryReport(ArrayList<Employee> employees) {

        if(employees.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }

        double total = 0;
        double max = employees.get(0).getSalary();
        double min = employees.get(0).getSalary();

        for(Employee e : employees) {

            total += e.getSalary();

            if(e.getSalary() > max)
                max = e.getSalary();

            if(e.getSalary() < min)
                min = e.getSalary();
        }

        double avg = total / employees.size();

        System.out.println("\nSalary Report");
        System.out.println("Total Employees: " + employees.size());
        System.out.println("Total Salary: " + total);
        System.out.println("Average Salary: " + avg);
        System.out.println("Highest Salary: " + max);
        System.out.println("Lowest Salary: " + min);
    }
}