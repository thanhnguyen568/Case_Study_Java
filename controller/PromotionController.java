package controller;

import java.util.Scanner;

public class PromotionController {
    static Scanner scanner = new Scanner(System.in);
    static int choice;

    public static void promotionManagement(){

        do {
            try {
                System.out.print("Booking Management:\n"
                        + "1.Display list customers use service\n"
                        + "2.Display list customers get voucher\n"
                        + "3.Return main menu\n"
                        + "Choice one option= ");
                choice = Integer.parseInt(scanner.nextLine());
                System.out.println("----------");
            }catch (NumberFormatException e){
                System.err.println("Enter option with wrong pattern, please re-do:");
                choice = -1;
            }
        }while (choice < 1 || choice > 3);

        switch (choice) {
            case 1:
                System.out.println("ch?a code 1");
                break;
            case 2:
                System.out.println("ch?a code 2");
                break;
            case 3:
                FuramaController.displayMainMenu();
                break;
        }
    }
}
