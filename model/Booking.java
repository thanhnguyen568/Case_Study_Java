package model;

import java.util.Objects;

public class Booking implements Comparable<Booking>{
    private String bookingCode;
    private String startDay;
    private String endDay;
    private String customerCode;
    private String codeService;
    private String rentalType;

    public Booking() {
    }

    public Booking(String bookingCode, String startDay, String endDay, String customerCode, String codeService, String rentalType) {
        this.bookingCode = bookingCode;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerCode = customerCode;
        this.codeService = codeService;
        this.rentalType = rentalType;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s\n", getBookingCode(), getStartDay(), getEndDay(), getCustomerCode(), getCodeService(), getRentalType());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode=" + bookingCode +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", codeService='" + codeService + '\'' +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(startDay, booking.startDay) && Objects.equals(endDay, booking.endDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDay, endDay);
    }

    @Override
    public int compareTo(Booking o) {
        return  this.getBookingCode().compareTo(o.getBookingCode());
    }
}
