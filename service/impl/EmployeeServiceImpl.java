package service.impl;

import controller.EmployeeController;
import model.Employee;
import service.EmployeeService;
import util.NameComparator;
import util.ReadFileEmployeeUtil;
import util.SalaryComparator;
import util.WriteFileEmployeeUtil;
import validate.regex.CustomizeRegex;
import validate.ValidatePerson;

import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService, CustomizeRegex {
    Scanner scanner = new Scanner(System.in);
    private static final String FILE_PATH = "D:\\CodeGym\\Case_Study_Java\\src\\data\\employee.csv";

    @Override
    public void display(){
        List<Employee> employeeList = ReadFileEmployeeUtil.readFile(FILE_PATH);

        System.out.println("Display list employees:");
        if (employeeList.size() == 0) {
            System.out.println("The list is empty !");
        } else {
            for (Employee employee : employeeList) {
                System.out.println(employee.toString());
            }
        }
    }

    @Override
    public void create() {
        List<Employee> employeeList = ReadFileEmployeeUtil.readFile(FILE_PATH);

        /**
         * T?o class validate ph??ng th?c tr? t?ng th?c tính, ph??ng th?c tr? ??i t??ng
         */
        System.out.println("Create a new employee...");
        Employee employee = ValidatePerson.infoEmployee();
        employeeList.add(employee);

        WriteFileEmployeeUtil.writeEmployeeFile(FILE_PATH, employeeList);
        System.out.println("Create successful!");
    }

    @Override
    public void update() {
        List<Employee> employeeList = ReadFileEmployeeUtil.readFile(FILE_PATH);

        int id;
        do {
            try {
                System.out.print("Input id wanna edit=");
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Number Format Exception");
                id = -1;
            }
        } while (id < 0);

        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (id == employeeList.get(i).getId()) {
                employeeList.set(i, ValidatePerson.infoEmployee());
                found = true;
                System.out.println("Update successful!");
            }
        }
        if (!found) {
            System.out.println("Not found");
        }

        WriteFileEmployeeUtil.writeEmployeeFile(FILE_PATH, employeeList);
    }

    @Override
    public void delete() {
        List<Employee> employeeList = ReadFileEmployeeUtil.readFile(FILE_PATH);

        int id;
        do {
            try {
                System.out.println("Input id wanna delete=");
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Number Format Exception");
                id = -1;
            }
        } while (id < 0);

        System.out.println("Do you wanna delete id: " + id + " ?");
        System.out.println("1. Confirm");
        System.out.println("2. Cancel and return menu");

        int choice;
        do {
            try {
                System.out.print("Input option: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Number Format Exception");
                choice = -1;
            }
        } while (choice < 1 | choice > 2);

        switch (choice) {
            case 1:
                boolean found = false;
                for (int i = 0; i < employeeList.size(); i++) {
                    if (id == employeeList.get(i).getId()) {
                        employeeList.remove(employeeList.get(i));
                        found = true;
                        System.out.println("Delete successful!");
                    }
                }
                if (!found) {
                    System.out.println("Not found");
                }

                WriteFileEmployeeUtil.writeEmployeeFile(FILE_PATH, employeeList);
                break;
            case 2:
                System.out.println("Cancel and return menu");
                    EmployeeController.employeeManagement();
                break;
        }
    }

    public void sortByName() {
        List<Employee> employeeList = ReadFileEmployeeUtil.readFile(FILE_PATH);

        employeeList.sort(new SalaryComparator());
//        employeeList.sort(new SalaryComparator().reversed());
//        employeeList.sort(new NameComparator().reversed());

        /**
         * Reversed()
         * employeeList.sort(new NameComparator().reversed());
         */

        System.out.println("Display list employees:");
        if (employeeList.size() == 0) {
            System.out.println("The list is empty !");
        } else {
            for (Employee employee : employeeList) {
                System.out.println(employee.toString());
            }
        }
    }
}
