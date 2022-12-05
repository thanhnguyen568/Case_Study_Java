package util;

import model.Booking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class WriteFileBookingUtil {
    private static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static void writeBookingFile(String path, Set<Booking> bookingSet) throws IOException {
        String data = "";
        for (Booking booking : bookingSet) {
            data += booking.getInfo();
        }

        writeFile(path, data);
    }
}
