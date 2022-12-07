package model;

import java.time.LocalDate;

public class Customer extends Person{
    private int customerCode;
    private String customerType;
//    public final String MEMBER = "Member";
//    public final String SILVER = "Silver";
//    public final String GOLD = "Gold";
//    public final String PLATINUM = "Platinum";
//    public final String DIAMOND = "Diamond";
    private String address;

    public Customer() {
    }

    public Customer(String name, LocalDate birthday, String gender, String identityCode, String phoneNumber, String email, int customerCode, String customerType, String address) {
        super(name, birthday, gender, identityCode, phoneNumber, email);
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.address = address;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\n", getName(), getBirthdayStr(getBirthday()), getGender(), getIdentityCode(), getPhoneNumber(), getEmail(), getCustomerCode(), getCustomerType(), getAddress());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerCode=" + customerCode +
                ", customerName=" + getName() +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
