package controller;

import service.impl.FacilityServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class FacilityController {
    static Scanner scanner = new Scanner(System.in);
    static int choice;

    public static void facilityManagement() throws IOException {
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
            } catch (NumberFormatException e) {
                System.err.println("Enter option with wrong pattern, please re-do:");
                choice = Integer.parseInt(scanner.nextLine());
            }
            System.out.println("----------");
        } while (choice < 1 || choice > 4);

        switch (choice) {
            case 1:
                facilityServiceImpl.display();
                break;
            case 2:
                facilityServiceImpl.create();
                break;
            case 3:
                facilityServiceImpl.displayMaintenance();
                break;
            case 4:
                FuramaController.displayMainMenu();
                break;
        }
    }
}
