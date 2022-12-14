package controller;

import service.impl.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityController {
    static Scanner scanner = new Scanner(System.in);
    static int choice;

    public static void facilityManagement() {
        FacilityServiceImpl facilityServiceImpl = new FacilityServiceImpl();

        do {
            try {
                System.out.print("Facility Management:\n"
                        + "1.Display list facility\n"
                        + "2.Add new facility\n"
                        + "3.Display list facility maintenance\n"
                        + "4.Return main menu\n"
                        + "Choice one option= ");
                choice = Integer.parseInt(scanner.nextLine());
                System.out.println("----------");
            } catch (NumberFormatException e) {
                System.err.println("Enter option with wrong pattern, please re-do:");
                choice = -1;
            }
        } while (choice < 1 || choice > 4);

        switch (choice) {
            case 1:
                facilityServiceImpl.display();
                FuramaController.displayMainMenu();
                break;
            case 2:
                facilityServiceImpl.create();
                FuramaController.displayMainMenu();
                break;
            case 3:
                facilityServiceImpl.displayMaintenance();
                FuramaController.displayMainMenu();
                break;
            case 4:
                FuramaController.displayMainMenu();
                break;
        }
    }
}
