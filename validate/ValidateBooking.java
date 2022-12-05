package validate;

import model.Booking;
import validate.regex.CustomizeRegex;

import java.util.Scanner;

public class ValidateBooking implements CustomizeRegex {
    static Scanner scanner = new Scanner(System.in);

    public static Booking infoBooking() {
        System.out.print("Input bookingCode");
        String bookingCode = scanner.nextLine();

        System.out.print("Input startDay");
        String startDay = scanner.nextLine();

        System.out.print("Input endDay");
        String endDay = scanner.nextLine();

        System.out.print("Input customerCode");
        String customerCode = scanner.nextLine();

        System.out.print("Input codeService");
        String codeService = scanner.nextLine();
        while (!codeService.matches(REGEX_CODE_VILLA)) {
            System.err.println("Enter code service with wrong pattern, please re-do:");
            codeService = scanner.nextLine();
        }

        System.out.print("Input rentalType");
        String rentalType = scanner.nextLine();
        while (!rentalType.matches(REGEX_RENTAL_TYPE)) {
            System.err.println("Enter rental type with wrong pattern, please re-do: Hour|Day|Month|Year");
            rentalType = scanner.nextLine();
        }

        return new Booking(bookingCode, startDay, endDay, customerCode, codeService, rentalType);
    }
}
