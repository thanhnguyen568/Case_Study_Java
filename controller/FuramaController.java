package controller;

import validate.CustomizeException;

import java.io.IOException;
import java.util.Scanner;

public class FuramaController {
    static Scanner scanner = new Scanner(System.in);
    static int choice;

    public static void displayMainMenu() {

        do {
            try {
                System.out.print("-----Main Menu:-----\n"
                        + "1.Employee Management\n"
                        + "2.Customer Management\n"
                        + "3.Facility Management\n"
                        + "4.Booking Management\n"
                        + "5.Promotion Management\n"
                        + "6.Exit\n"
                        + "Choice one option= ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Enter option with wrong pattern, please re-do:");
                choice = Integer.parseInt(scanner.nextLine());
            }
            System.out.println("----------");
        } while (choice < 0 || choice > 6);

        try {
            switch (choice) {
                case 1:
                    EmployeeController.employeeManagement();
                    break;
                case 2:
                    CustomerController.customerManagement();
                    break;
                case 3:
                    FacilityController.facilityManagement();
                    break;
                case 4:
                    BookingController.bookingManagement();
                    break;
                case 5:
                    PromotionController.promotionManagement();
                    break;
                case 6:
                    System.out.println("Successful Exit!");
                    System.exit(0);
                    break;
            }
        } catch (IOException | CustomizeException e) {
            e.printStackTrace();
            displayMainMenu();
        }
    }
}
