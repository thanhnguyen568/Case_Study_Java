package service.impl;

import model.Customer;
import service.CustomerService;
import util.ReadFileCustomerUtil;
import util.WriteFileCustomerUtil;
import validate.ValidatePerson;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    Scanner scanner = new Scanner(System.in);
    private static final String FILE_PATH = "D:\\CodeGym\\Case_Study_Java\\src\\data\\customer.csv";

    @Override
    public void display() throws IOException {
        List<Customer> customerList = ReadFileCustomerUtil.readFile(FILE_PATH);

        System.out.println("Display list customer:");
        if (customerList.size() == 0) {
            System.out.println("The list is empty !");
        } else {
            for (Customer customer : customerList) {
                System.out.println(customer.toString());
            }
        }
        System.out.println("----------");
    }

    @Override
    public void create() throws IOException {
        List<Customer> customerList = ReadFileCustomerUtil.readFile(FILE_PATH);

        System.out.println("Create a new employee...");
        Customer customer = ValidatePerson.infoCustomer();
        customerList.add(customer);

        WriteFileCustomerUtil.writeCustomerFile(FILE_PATH, customerList);
        System.out.println("Create successful!");
    }

    @Override
    public void update() throws IOException {
        List<Customer> customerList = ReadFileCustomerUtil.readFile(FILE_PATH);

        int customerCode;

        do {
            System.out.print("Input customer code wanna edit=");
            customerCode = Integer.parseInt(scanner.nextLine());
        } while (customerCode < 2000 || customerCode > 9999);

        boolean found = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerCode == customerList.get(i).getCustomerCode()) {
                customerList.set(i, ValidatePerson.infoCustomer());
                found = true;
                System.out.println("Update successful!");
            }
        }

        if (!found) {
            System.out.println("Not found!");
        }

        WriteFileCustomerUtil.writeCustomerFile(FILE_PATH, customerList);
    }

    @Override
    public void delete() throws IOException {
        List<Customer> customerList = ReadFileCustomerUtil.readFile(FILE_PATH);

        int id;
        do {
            System.out.print("Input customer code wanna delete=");
            id = Integer.parseInt(scanner.nextLine());
        } while (id < 1000);

        boolean found = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (id == customerList.get(i).getCustomerCode()) {
                customerList.remove(customerList.get(i));
                found = true;
                System.out.println("Delete successful!");
            }
        }
        if (!found) {
            System.out.println("Not found");
        }

        WriteFileCustomerUtil.writeCustomerFile(FILE_PATH, customerList);
    }
}
