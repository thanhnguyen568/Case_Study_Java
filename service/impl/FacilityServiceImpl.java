package service.impl;

import controller.FuramaController;
import model.House;
import model.Room;
import model.Villa;
import service.FacilityService;
import util.*;
import validate.ValidateFacility;

import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    static Scanner scanner = new Scanner(System.in);
    private static final String VILLA_PATH = "D:\\CodeGym\\Case_Study_Java\\src\\data\\villa.csv";
    private static final String HOUSE_PATH = "D:\\CodeGym\\Case_Study_Java\\src\\data\\house.csv";
    private static final String ROOM_PATH = "D:\\CodeGym\\Case_Study_Java\\src\\data\\room.csv";

    @Override
    public void display(){

        Map<Villa, Integer> villaMap = ReadFileVillaUtil.readFile(VILLA_PATH);
        Map<Room, Integer> roomMap = ReadFileRoomUtil.readFile(ROOM_PATH);
        Map<House, Integer> houseMap = ReadFileHouseUtil.readFile(HOUSE_PATH);

        System.out.println("Display facility:");
        if (!villaMap.isEmpty() && !houseMap.isEmpty() && !roomMap.isEmpty()) {
            for (Map.Entry<Villa, Integer> item : villaMap.entrySet()) {
                System.out.printf("%s - %s\n", item.getKey(), item.getValue());
            }

            for (Map.Entry<House, Integer> item : houseMap.entrySet()) {
                System.out.printf("%s - %s\n", item.getKey(), item.getValue());
            }

            for (Map.Entry<Room, Integer> item : roomMap.entrySet()) {
                System.out.printf("%s - %s times\n", item.getKey(), item.getValue());
            }
        } else {
            System.out.println("File is Empty");
        }
    }

    @Override
    public void create(){
        int choice;
        do {
            try {
                System.out.print("Add new facility:\n"
                        + "1.Add new Villa\n"
                        + "2.Add new House\n"
                        + "3.Add new Room\n"
                        + "4.back to menu\n"
                        + "Choice one option= ");
                choice = Integer.parseInt(scanner.nextLine());
                System.out.println("----------");
            }catch (NumberFormatException e){
                e.printStackTrace();
                choice = -1;
            }
        } while (choice < 1 || choice > 4);

        switch (choice) {
            case 1:
                Map<Villa, Integer> villaIntegerMap = ReadFileVillaUtil.readFile(VILLA_PATH);

                villaIntegerMap.put(ValidateFacility.infoVilla(), 0);

                WriteFileVillaUtil.writeVillaFile(VILLA_PATH, villaIntegerMap);
                break;
            case 2:
                Map<House, Integer> houseIntegerMap = ReadFileHouseUtil.readFile(HOUSE_PATH);

                houseIntegerMap.put(ValidateFacility.infoHouse(), 0);

                WriteFileHouseUtil.writeHouseFile(HOUSE_PATH, houseIntegerMap);
                break;
            case 3:
                Map<Room, Integer> roomIntegerMap = ReadFileRoomUtil.readFile(ROOM_PATH);

                roomIntegerMap.put(ValidateFacility.infoRoom(), 0);

                WriteFileRoomUtil.writeRoomFile(ROOM_PATH, roomIntegerMap);
                break;
            case 4:
                FuramaController.displayMainMenu();
                break;
        }
    }

    @Override
    public void update(){

    }

    @Override
    public void delete(){

    }

    @Override
    public void displayMaintenance(){
        Map<Villa, Integer> villaMap = ReadFileVillaUtil.readFile(VILLA_PATH);
        Map<Room, Integer> roomMap = ReadFileRoomUtil.readFile(ROOM_PATH);
        Map<House, Integer> houseMap = ReadFileHouseUtil.readFile(HOUSE_PATH);

        System.out.println("Display facility:");
        if (!villaMap.isEmpty() && !houseMap.isEmpty() && !roomMap.isEmpty()) {
            for (Map.Entry<Villa, Integer> item : villaMap.entrySet()) {
                if (item.getValue() >= 5) {
                    System.out.printf("%s - %s\n", item.getKey(), item.getValue());
                } else {
                    System.out.println("No Villa need to maintenance");
                }
            }

            for (Map.Entry<House, Integer> item : houseMap.entrySet()) {
                if (item.getValue() >= 5) {
                    System.out.printf("%s - %s\n", item.getKey(), item.getValue());
                } else {
                    System.out.println("No House need to maintenance");
                }
            }

            for (Map.Entry<Room, Integer> item : roomMap.entrySet()) {
                if (item.getValue() >= 5) {
                    System.out.printf("%s - %s times\n", item.getKey(), item.getValue());
                } else {
                    System.out.println("No Room need to maintenance");
                }
            }
        } else {
            System.out.println("File is empty");
        }
    }
}
