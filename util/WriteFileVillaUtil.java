package util;

import model.Villa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteFileVillaUtil {
    private static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static void writeVillaFile(String path, Map<Villa, Integer> villaMap) throws IOException {
        String data = "";

        for (Map.Entry<Villa, Integer> item : villaMap.entrySet()) {
            data += item.getKey().getInfo() + item.getValue() + "\n";
        }

        writeFile(path, data);
    }
}
