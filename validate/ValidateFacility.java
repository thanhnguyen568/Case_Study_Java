package validate;

import model.House;
import model.Room;
import model.Villa;
import validate.regex.CustomizeRegex;

import java.util.Scanner;

public class ValidateFacility implements CustomizeRegex {
    static Scanner scanner = new Scanner(System.in);

    public static String codeService() {
        System.out.println("Input codeService");
        String codeService = scanner.nextLine();
        while (!codeService.matches(REGEX_CODE_VILLA)) {
            System.err.println("Enter code service with wrong pattern, please re-do:");
            codeService = scanner.nextLine();
        }
        return codeService;
    }

    public static String nameService() {
        System.out.println("Input nameService");
        String nameService = scanner.nextLine();
        while (!nameService.matches(REGEX_NAME_SERVICE)) {
            System.err.println("Enter name service with wrong pattern, please re-do: Villa|House|Room");
            nameService = scanner.nextLine();
        }
        return nameService;
    }

    public static double usableArea() {
        double usableArea;
        do {
            try {
                System.out.println("Input usableArea >30");
                usableArea = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Enter usable area with wrong pattern, please re-do:");
                usableArea = -1;
            }
        } while (usableArea <= 30.0);
        return usableArea;
    }

    public static double rentalCosts() {
        double rentalCosts;
        do {
            try {
                System.out.println("Input rentalCosts >0");
                rentalCosts = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Enter rental costs with wrong pattern, please re-do:");
                rentalCosts = -1;
            }
        } while (rentalCosts <= 0.0);
        return rentalCosts;
    }

    public static int maxNumberOfPeople() {
        int maxNumberOfPeople;
        do {
            try {
                System.out.println("Input maxNumberOfPeople");
                maxNumberOfPeople = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Enter rental costs with wrong pattern, please re-do:");
                maxNumberOfPeople = -1;
            }
        } while (maxNumberOfPeople <= 0 || maxNumberOfPeople >= 20);
        return maxNumberOfPeople;
    }

    public static String rentalType() {
        System.out.println("Input rentalType");
        String rentalType = scanner.nextLine();
        while (!rentalType.matches(REGEX_RENTAL_TYPE)) {
            System.err.println("Enter rental type with wrong pattern, please re-do: Hour|Day|Month|Year");
            rentalType = scanner.nextLine();
        }
        return rentalType;
    }

    public static String roomStand() {
        System.out.println("Input roomStand");
        String roomStand = scanner.nextLine();
        while (!roomStand.matches(REGEX_ROOM_STAND)) {
            System.err.println("Enter room stand with wrong pattern, please re-do:");
            roomStand = scanner.nextLine();
        }
        return roomStand;
    }

    public static double swimmingPoolArea() {
        double swimmingPoolArea;
        do {
            try {
                System.out.println("Input swimmingPoolArea");
                swimmingPoolArea = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Enter swimming pool area with wrong pattern, please re-do:");
                swimmingPoolArea = -1;
            }
        } while (swimmingPoolArea <= 30.0);
        return swimmingPoolArea;
    }

    public static int numberOfFloors() {
        int numberOfFloors;
        do {
            try {
                System.out.println("Input numberOfFloors");
                numberOfFloors = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Enter swimming pool area with wrong pattern, please re-do:");
                numberOfFloors = Integer.parseInt(scanner.nextLine());
            }
        } while (numberOfFloors <= 0);
        return numberOfFloors;
    }

    public static String freeService() {
        System.out.println("Input freeService");
        String freeService = scanner.nextLine();
        while (!freeService.matches(REGEX_FREE_SERVICE)) {
            System.err.println("Enter room stand with wrong pattern, please re-do:");
            freeService = scanner.nextLine();
        }
        return freeService;
    }

    public static Villa infoVilla() {
        String codeService = codeService();
        String nameService = nameService();
        double usableArea = usableArea();
        double rentalCosts = rentalCosts();
        int maxNumberOfPeople = maxNumberOfPeople();
        String rentalType = rentalType();
        String roomStand = roomStand();
        double swimmingPoolArea = swimmingPoolArea();
        int numberOfFloors = numberOfFloors();
        return new Villa(codeService, nameService, usableArea, rentalCosts, maxNumberOfPeople, rentalType, roomStand, swimmingPoolArea, numberOfFloors);
    }

    public static House infoHouse() {
        String codeService = codeService();
        String nameService = nameService();
        double usableArea = usableArea();
        double rentalCosts = rentalCosts();
        int maxNumberOfPeople = maxNumberOfPeople();
        String rentalType = rentalType();
        String roomStand = roomStand();
        int numberOfFloors = numberOfFloors();
        return new House(codeService, nameService, usableArea, rentalCosts, maxNumberOfPeople, rentalType, roomStand, numberOfFloors);
    }

    public static Room infoRoom() {
        String codeService = codeService();
        String nameService = nameService();
        double usableArea = usableArea();
        double rentalCosts = rentalCosts();
        int maxNumberOfPeople = maxNumberOfPeople();
        String rentalType = rentalType();
        String freeService = freeService();
        return new Room(codeService, nameService, usableArea, rentalCosts, maxNumberOfPeople, rentalType, freeService);
    }
}
