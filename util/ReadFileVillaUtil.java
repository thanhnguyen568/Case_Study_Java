package util;

import model.Villa;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadFileVillaUtil {
    public static Map<Villa, Integer> readFile(String FILE_PATH) throws IOException {
        Map<Villa, Integer> villaIntegerMap = new LinkedHashMap<>();
        BufferedReader buff = new BufferedReader(new FileReader(FILE_PATH));

        String line;
        String[] temp;
        Villa villa;

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
                double swimmingPoolArea = Double.parseDouble(temp[7]);
                int numberOfFloors = Integer.parseInt(temp[8]);
                int numberOfUses = Integer.parseInt(temp[9]);

                villa = new Villa(codeService, nameService, usableArea, rentalCosts, maxNumberOfPeople, rentalType, roomStand, swimmingPoolArea, numberOfFloors);
                villaIntegerMap.put(villa, numberOfUses);
            }
        }

        buff.close();
        return villaIntegerMap;
    }
}
