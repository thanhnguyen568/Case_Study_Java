package util;

import model.Room;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteFileRoomUtil {
    private static void writeFile(String path, String data) {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(path);
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void writeRoomFile(String path, Map<Room, Integer> roomMap) {
        String data = "";

        for (Map.Entry<Room, Integer> item : roomMap.entrySet()) {
            data += item.getKey().getInfo() + item.getValue() + "\n";
        }

        writeFile(path, data);
    }
}
