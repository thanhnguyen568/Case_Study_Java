package validate;

import model.Customer;
import model.Employee;
import validate.regex.CustomizeRegex;

import java.util.Scanner;

public class ValidatePerson implements CustomizeRegex {
    static Scanner scanner = new Scanner(System.in);

    public static String name() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        while (!name.matches(REGEX_NAME)) {
            System.err.println("Enter name with wrong pattern, please re-do:");
            name = scanner.nextLine();
        }
        return name;
    }

    public static String birthDay() {
        System.out.print("Birthday: ");
        String birthDay = scanner.nextLine();
        while (!birthDay.matches(REGEX_BIRTH_DAY)) {
            System.err.println("Enter birth day with wrong pattern, please re-do:");
            birthDay = scanner.nextLine();
        }
        return birthDay;
    }

    public static String gender() {
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        while (!gender.matches(REGEX_GENDER)) {
            System.err.println("Enter gender with wrong pattern, please re-do: male|female|unknown ");
            gender = scanner.nextLine();
        }
        return gender;
    }

    public static String idCode() {
        System.out.print("IdentityCode: ");
        return scanner.nextLine();
    }

    public static String phone() {
        System.out.print("Phone number: ");
        String phone = scanner.nextLine();
        while (!phone.matches(REGEX_PHONE)) {
            System.err.println("Enter email with wrong pattern, please re-do: ");
            phone = scanner.nextLine();
        }
        return phone;
    }

    public static String email() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        while (!email.matches(REGEX_EMAIL)) {
            System.err.println("Enter email with wrong pattern, please re-do: ");
            email = scanner.nextLine();
        }
        return email;
    }

    public static int id() {
        int id;
        do {
            try {
                System.out.print("Staff id: ");
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Enter staff id with wrong pattern, please re-do: ");
                id = -1;
            }
        } while (id > 0);
        return id;
    }

    public static String level() {
        System.out.print("Level: ");
        String level = scanner.nextLine();
        while (!level.matches(REGEX_LEVEL)) {
            System.err.println("Enter level with wrong pattern, please re-do: Intermediate|College|University|AfterUniversity");
            level = scanner.nextLine();
        }
        return level;
    }

    public static String position() {
        System.out.print("Position: ");
        String position = scanner.nextLine();
        while (!position.matches(REGEX_POSITION)) {
            System.err.println("Enter position with wrong pattern, please re-do: Receptionist|Staff|Experts|Monitoring|Manage|Director");
            position = scanner.nextLine();
        }
        return position;
    }

    public static int salary() {
        int salary;
        do {
            try {
                System.out.print("Input Salary :");
                salary = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Enter position with wrong pattern, please re-do: ");
                salary = -1;
            }
        } while (salary > 0);
        return salary;
    }

    public static int customerCode() {
        int customerCode;
        do {
            try {
                System.out.print("Customer code: ");
                customerCode = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Enter position with wrong pattern, please re-do: ");
                customerCode = -1;
            }
        } while (customerCode < 0);
        return customerCode;
    }

    public static String customerType() {
        System.out.print("Customer Type: ");
        String customerType = scanner.nextLine();
        while (!customerType.matches(REGEX_CUSTOMER_TYPE)) {
            System.err.println("Enter customerType with wrong pattern, please re-do: Member|Silver|Gold|Platinum|Diamond");
            customerType = scanner.nextLine();
        }
        return customerType;
    }

    public static String address() {
        System.out.print("Address: ");
        return scanner.nextLine();
    }

    public static Employee infoEmployee() {
        String name = name();
        String birthDay = birthDay();
        String gender = gender();
        String idCode = idCode();
        String phone = phone();
        String email = email();
        int id = id();
        String level = level();
        String position = position();
        int salary = salary();
        return new Employee(name, birthDay, gender, idCode, phone, email, id, level, position, salary);
    }

    public static Customer infoCustomer() {
        String name = name();
        String birthDay = birthDay();
        String gender = gender();
        String idCode = idCode();
        String phone = phone();
        String email = email();
        int customerCode = customerCode();
        String customerType = customerType();
        String address = address();
        return new Customer(name, birthDay, gender, idCode, phone, email, customerCode, customerType, address);
    }
}
