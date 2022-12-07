package controller;

import service.impl.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerController {
    static Scanner scanner = new Scanner(System.in);
    static int choice;

    public static void customerManagement() {
        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();

        do {
            try {
                System.out.print("Customer Management:\n"
                        + "1.Display list customers\n"
                        + "2.Add new customer\n"
                        + "3.Edit customer\n"
                        + "4.Delete customer\n"
                        + "5.Return main menu\n"
                        + "Choice one option= ");
                choice = Integer.parseInt(scanner.nextLine());
                System.out.println("----------");
            } catch (NumberFormatException e) {
                System.err.println("Enter option with wrong pattern, please re-do:");
                choice = -1;
            }
        } while (choice < 1 || choice > 5);

        switch (choice) {
            case 1:
                customerServiceImpl.display();
                FuramaController.displayMainMenu();
                break;
            case 2:
                customerServiceImpl.create();
                FuramaController.displayMainMenu();
                break;
            case 3:
                customerServiceImpl.update();
                FuramaController.displayMainMenu();
                break;
            case 4:
                customerServiceImpl.delete();
                FuramaController.displayMainMenu();
                break;
            case 5:
                FuramaController.displayMainMenu();
                break;
        }
    }
}
