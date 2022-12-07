package util;

import model.Booking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class WriteFileBookingUtil {
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

    public static void writeBookingFile(String path, Set<Booking> bookingSet){
        String data = "";
        for (Booking booking : bookingSet) {
            data += booking.getInfo();
        }

        writeFile(path, data);
    }
}
