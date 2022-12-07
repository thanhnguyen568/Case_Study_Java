package controller;

import service.impl.BookingServiceImpl;
import service.impl.ContractServiceImpl;

import java.util.Scanner;

public class BookingController {
    static Scanner scanner = new Scanner(System.in);
    static int choice;

    public static void bookingManagement(){
        BookingServiceImpl bookingService = new BookingServiceImpl();
        ContractServiceImpl contractService = new ContractServiceImpl();
        do {
            try {
                System.out.print("Booking Management:\n"
                        + "1.Add new booking\n"
                        + "2.Display list booking\n"
                        + "3.Create new contracts\n"
                        + "4.Display list contracts\n"
                        + "5.Edit contracts\n"
                        + "6.Return main menu\n"
                        + "Choice one option= ");
                choice = Integer.parseInt(scanner.nextLine());
                System.out.println("----------");
            } catch (NumberFormatException e) {
                System.err.println("Enter option with wrong pattern, please re-do:");
                choice = -1;
            }
        }while (choice < 1 || choice > 6);

        switch (choice) {
            case 1:
                bookingService.create();
                break;
            case 2:
                bookingService.display();
                break;
            case 3:
                contractService.create();
                break;
            case 4:
                contractService.display();
                break;
            case 5:
                contractService.update();
            case 6:
                FuramaController.displayMainMenu();
        }
    }
}
