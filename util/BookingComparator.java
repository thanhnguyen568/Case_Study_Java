package util;

import model.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {

    @Override
    public int compare(Booking first, Booking second) {
        int result = first.getStartDay().compareTo(second.getStartDay());
        if (result ==0) {
            return first.getEndDay().compareTo(second.getEndDay());
        }
        return result;
    }

}
