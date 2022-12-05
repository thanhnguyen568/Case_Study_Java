package util;

import model.House;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadFileHouseUtil {
    public static Map<House, Integer> readFile(String FILE_PATH) throws IOException {
        Map<House, Integer> houseIntegerMap = new LinkedHashMap<>();
        BufferedReader buff = new BufferedReader(new FileReader(FILE_PATH));

        String line;
        String[] temp;
        House house;

        while ((line = buff.readLine()) != null) {
            if (!"".equals(line)) {
                temp = line.split(",");

                String codeService = temp[0];
                String nameService = temp[1];
                double usableArea = Double.parseDouble(temp[2]);
                double rentalCosts = Double.parseDouble(temp[3]);
                int maxNumberOfPeople = Integer.parseInt(temp[4]);
                String rentalType = temp[5];
                String roomStand = temp[6];
                int numberOfFloors = Integer.parseInt(temp[7]);
                int numberOfUses = Integer.parseInt(temp[8]);

                house = new House( codeService,  nameService,  usableArea,  rentalCosts,  maxNumberOfPeople,  rentalType,  roomStand, numberOfFloors);
                houseIntegerMap.put(house, numberOfUses);
            }
        }

        buff.close();
        return houseIntegerMap;
    }
}
