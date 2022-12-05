package service.impl;

import controller.BookingController;
import model.*;
import service.BookingService;
import util.*;
import validate.ValidateBooking;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BookingServiceImpl implements BookingService {
    private static final String FILE_PATH = "D:\\CodeGym\\Case_Study_Java\\src\\data\\booking.csv";
    private static final String CUSTOMER_PATH = "D:\\CodeGym\\Case_Study_Java\\src\\data\\customer.csv";
    private static final String VILLA_PATH = "D:\\CodeGym\\Case_Study_Java\\src\\data\\villa.csv";
    private static final String HOUSE_PATH = "D:\\CodeGym\\Case_Study_Java\\src\\data\\house.csv";
    private static final String ROOM_PATH = "D:\\CodeGym\\Case_Study_Java\\src\\data\\room.csv";
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display() throws IOException {
        Set<Booking> bookingSet = ReadFileBookingUtil.readFile(FILE_PATH);

        System.out.println("Display set booking:");
        if (bookingSet.size() == 0) {
            System.out.println("The set booking is empty !");
        } else {
            for (Booking booking : bookingSet) {
                System.out.println(booking);
            }
        }
    }

    @Override
    public void create() throws IOException {
        /**
         * Display customer list
         */
        List<Customer> customerList = ReadFileCustomerUtil.readFile(CUSTOMER_PATH);

        System.out.println("Display list customer:");
        if (customerList.size() == 0) {
            System.out.println("The list is empty !");
        } else {
            for (Customer customer : customerList) {
                System.out.println(customer.toString());
            }
        }
        System.out.println("----------");

        /**
         * Display facility map
         */
        Map<Villa, Integer> villaMap = ReadFileVillaUtil.readFile(VILLA_PATH);
        Map<Room, Integer> roomMap = ReadFileRoomUtil.readFile(ROOM_PATH);
        Map<House, Integer> houseMap = ReadFileHouseUtil.readFile(HOUSE_PATH);

        System.out.println("Display facility:");
        if (!villaMap.isEmpty() && !houseMap.isEmpty() && !roomMap.isEmpty()) {
            // Display Villa
            for (Map.Entry<Villa, Integer> item : villaMap.entrySet()) {
                System.out.printf("%s - %s\n", item.getKey(), item.getValue());
            }

            // Display House
            for (Map.Entry<House, Integer> item : houseMap.entrySet()) {
                System.out.printf("%s - %s\n", item.getKey(), item.getValue());
            }

            // Display Room
            for (Map.Entry<Room, Integer> item : roomMap.entrySet()) {
                System.out.printf("%s - %s\n", item.getKey(), item.getValue());
            }
        } else {
            System.out.println("File is Empty");
        }
        System.out.println("----------");

        /**
         * Add booking
         */
        Set<Booking> bookingSet = ReadFileBookingUtil.readFile(FILE_PATH);
        int choice;
        do {
            System.out.println("1.Booking");
            System.out.println("2.Back to menu");
            System.out.print("Choice a option:");
            choice = Integer.parseInt(scanner.nextLine());
            System.out.println("----------");
        } while (choice < 1 || choice > 4);

        switch (choice) {
            case 1:
                bookingSet.add(ValidateBooking.infoBooking());
                WriteFileBookingUtil.writeBookingFile(FILE_PATH, bookingSet);
                break;
            case 2:
                BookingController.bookingManagement();
        }
    }

    @Override
    public void update() throws IOException {

    }

    @Override
    public void delete() throws IOException {

    }

}
