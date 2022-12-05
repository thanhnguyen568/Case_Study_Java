package controller;

import service.impl.EmployeeServiceImpl;
import validate.CustomizeException;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeController {
    static Scanner scanner = new Scanner(System.in);
    static int choice;

    public static void employeeManagement() throws IOException, CustomizeException {
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

        do {
            try {
                System.out.print("Employee Management:\n"
                        + "1.Display list employees\n"
                        + "2.Add new employee\n"
                        + "3.Edit employee\n"
                        + "4.Delete employee\n"
                        + "5.Return main menu\n"
                        + "Choice one option= ");
                choice = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.err.println("Enter option with wrong pattern, please re-do:");
                choice = Integer.parseInt(scanner.nextLine());
            }
            System.out.println("----------");
        } while (choice < 1 || choice > 5);

        switch (choice) {
            case 1:
                employeeServiceImpl.display();
                break;
            case 2:
                employeeServiceImpl.create();
                break;
            case 3:
                employeeServiceImpl.update();
                break;
            case 4:
                employeeServiceImpl.delete();
                break;
            case 5:
                FuramaController.displayMainMenu();
                break;
        }
    }
}
