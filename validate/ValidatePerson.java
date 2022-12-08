package validate;

import model.Customer;
import model.Employee;
import validate.regex.CustomizeRegex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValidatePerson implements CustomizeRegex {
    static Scanner scanner = new Scanner(System.in);

    public static String name() {
        System.out.println("Name: ");
        String name = scanner.nextLine();
        while (!name.matches(REGEX_NAME)) {
            System.err.println("Enter name with wrong pattern, please re-do:");
            name = scanner.nextLine();
        }
        return name;
    }

    //Write File
    public static LocalDate birthDay() {
        LocalDate birthday = null;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        boolean flag = true;
        while (flag) {
            try {

                System.out.println("Birthday: ");
                birthday = LocalDate.parse(scanner.nextLine(), dateFormat);
                LocalDate now = LocalDate.now();
                if (now.getYear() - birthday.getYear() < 18 || now.getYear() - birthday.getYear() > 100) {
                    throw new CustomizeException("Age You must be over 18 years old and less than 100 years old");
                }
                flag = false;

            } catch (NumberFormatException | DateTimeParseException e) {
                System.out.println("Date of Birth Incorrect Format (dd/MM/yyyy)");
            } catch (CustomizeException e) {
                e.printStackTrace();
            }
        }

        return birthday;
    }

    // Read File
    public static LocalDate parseLocalDate(String input) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(input, dateFormat);
    }

    public static String gender() {
        System.out.println("Gender: ");
        String gender = scanner.nextLine();
        while (!gender.matches(REGEX_GENDER)) {
            System.err.println("Enter gender with wrong pattern, please re-do: male|female|unknown ");
            gender = scanner.nextLine();
        }
        return gender;
    }

    public static String idCode() {
        System.out.println("IdentityCode: ");
        return scanner.nextLine();
    }

    public static String phone() {
        System.out.println("Phone number: ");
        String phone = scanner.nextLine();
        while (!phone.matches(REGEX_PHONE)) {
            System.err.println("Enter phone with wrong pattern, please re-do: ");
            phone = scanner.nextLine();
        }
        return phone;
    }

    public static String email() {
        System.out.println("Email: ");
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
                System.out.println("Staff id: ");
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Enter staff id with wrong pattern, please re-do: ");
                id = -1;
            }
        } while (id < 0);
        return id;
    }

    public static String level() {
        System.out.println("Level: ");
        String level = scanner.nextLine();
        while (!level.matches(REGEX_LEVEL)) {
            System.err.println("Enter level with wrong pattern, please re-do: Intermediate|College|University|AfterUniversity");
            level = scanner.nextLine();
        }
        return level;
    }

    public static String position() {
        System.out.println("Position: ");
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
                System.out.println("Input Salary :");
                salary = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Enter position with wrong pattern, please re-do: ");
                salary = -1;
            }
        } while (salary < 0);
        return salary;
    }

    public static int customerCode() {
        int customerCode;
        do {
            try {
                System.out.println("Customer code: ");
                customerCode = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Enter position with wrong pattern, please re-do: ");
                customerCode = -1;
            }
        } while (customerCode < 0);
        return customerCode;
    }

    public static String customerType() {
        System.out.println("Customer Type: ");
        String customerType = scanner.nextLine();
        while (!customerType.matches(REGEX_CUSTOMER_TYPE)) {
            System.err.println("Enter customerType with wrong pattern, please re-do: Member|Silver|Gold|Platinum|Diamond");
            customerType = scanner.nextLine();
        }
        return customerType;
    }

    public static String address() {
        System.out.println("Address: ");
        return scanner.nextLine();
    }

    public static Employee infoEmployee() {
        String name = name();
//        LocalDate birthDay = parseLocalDate(birthDay());
        LocalDate birthDay = birthDay();
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
        LocalDate birthDay = birthDay();
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
