package util;

import model.Booking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFileBookingUtil {
    public static Set<Booking> readFile(String FILE_PATH) throws IOException {
        Set<Booking> bookingSet = new TreeSet<>();
        BufferedReader buff = new BufferedReader(new FileReader(FILE_PATH));

        String line;
        String[] temp;
        Booking booking;

        while ((line = buff.readLine()) != null) {
            if (!"".equals(line)) {
                temp = line.split(",");

                String bookingCode = temp[0];
                String startDay = (temp[1]);
                String endDay = (temp[2]);
                String customerCode = temp[3];
                String nameService = temp[4];
                String rentalType = temp[5];

                booking = new Booking(bookingCode, startDay, endDay, customerCode, nameService, rentalType);
                bookingSet.add(booking);
            }
        }

        buff.close();
        return bookingSet;
    }
}
