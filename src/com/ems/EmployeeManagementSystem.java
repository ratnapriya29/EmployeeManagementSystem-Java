package com.ems;
import java.util.*;

public class EmployeeManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static HashMap<String, Employee> employeeMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        employees = EmployeeFileHandler.loadEmployees();

        for(Employee e : employees)
            employeeMap.put(e.getId(), e);

        while(true) {

            System.out.println("\n=== EMPLOYEE MANAGEMENT SYSTEM ===");
            System.out.println("1 Add Employee");
            System.out.println("2 View Employees");
            System.out.println("3 Search Employee");
            System.out.println("4 Update Employee");
            System.out.println("5 Delete Employee");
            System.out.println("6 Salary Report");
            System.out.println("7 Save");
            System.out.println("8 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    displayEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    EmployeeReportGenerator.generateSalaryReport(employees);
                    break;

                case 7:
                    EmployeeFileHandler.saveEmployees(employees);
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }

    static void addEmployee() {

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        if(employeeMap.containsKey(id)) {
            System.out.println("Employee already exists!");
            return;
        }

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Department: ");
        String dept = sc.nextLine();

        System.out.print("Position: ");
        String pos = sc.nextLine();

        System.out.print("Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        Employee e = new Employee(id,name,dept,pos,salary);

        employees.add(e);
        employeeMap.put(id,e);

        System.out.println("Employee added.");
    }

    static void displayEmployees() {

        for(Employee e : employees)
            System.out.println(e);
    }

    static void searchEmployee() {

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        if(employeeMap.containsKey(id))
            System.out.println(employeeMap.get(id));
        else
            System.out.println("Employee not found.");
    }

    static void updateEmployee() {

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        Employee e = employeeMap.get(id);

        if(e == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("New Name: ");
        e.setName(sc.nextLine());

        System.out.print("New Department: ");
        e.setDepartment(sc.nextLine());

        System.out.print("New Position: ");
        e.setPosition(sc.nextLine());

        System.out.print("New Salary: ");
        e.setSalary(sc.nextDouble());
        sc.nextLine();

        System.out.println("Employee updated.");
    }

    static void deleteEmployee() {

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        Employee e = employeeMap.remove(id);

        if(e != null) {
            employees.remove(e);
            System.out.println("Employee deleted.");
        }
        else
            System.out.println("Employee not found.");
    }
}