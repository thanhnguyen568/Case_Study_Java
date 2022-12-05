package util;

import model.Room;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteFileRoomUtil {
    private static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static void writeRoomFile(String path, Map<Room, Integer> roomMap) throws IOException {
        String data = "";

        for (Map.Entry<Room, Integer> item : roomMap.entrySet()) {
            data += item.getKey().getInfo() + item.getValue() + "\n";
        }

        writeFile(path, data);
    }
}
