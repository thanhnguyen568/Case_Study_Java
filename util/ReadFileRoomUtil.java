package util;

import model.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadFileRoomUtil {
    public static Map<Room, Integer> readFile(String FILE_PATH){
        Map<Room, Integer> roomIntegerMap = new LinkedHashMap<>();
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new FileReader(FILE_PATH));

            String line;
            String[] temp;
            Room room;

            while ((line = buff.readLine()) != null) {
                if (!"".equals(line)) {
                    temp = line.split(",");

                    String codeService = temp[0];
                    String nameService = temp[1];
                    double usableArea = Double.parseDouble(temp[2]);
                    double rentalCosts = Double.parseDouble(temp[3]);
                    int maxNumberOfPeople = Integer.parseInt(temp[4]);
                    String rentalType = temp[5];
                    String freeService = temp[6];
                    int numberOfUses = Integer.parseInt(temp[7]);

                    room = new Room(codeService, nameService, usableArea, rentalCosts, maxNumberOfPeople, rentalType, freeService);
                    roomIntegerMap.put(room, numberOfUses);
                }
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        } finally {
            if (buff != null) {
                try {
                    buff.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return roomIntegerMap;
    }
}
