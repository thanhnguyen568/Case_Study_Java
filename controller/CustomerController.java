package controller;

import service.impl.CustomerServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class CustomerController {
    static Scanner scanner = new Scanner(System.in);
    static int choice;

    public static void customerManagement() throws IOException {
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
            } catch (NumberFormatException e) {
                System.err.println("Enter option with wrong pattern, please re-do:");
                choice = Integer.parseInt(scanner.nextLine());
            }
            System.out.println("----------");
        } while (choice < 1 || choice > 5);

        switch (choice) {
            case 1:
                customerServiceImpl.display();
                break;
            case 2:
                customerServiceImpl.create();
                break;
            case 3:
                customerServiceImpl.update();
                break;
            case 4:
                customerServiceImpl.delete();
                break;
            case 5:
                FuramaController.displayMainMenu();
                break;
        }
    }
}
