package util;

import model.Customer;
import validate.ValidatePerson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCustomerUtil {
    public static List<Customer> readFile(String FILE_PATH) throws IOException {
        List<Customer> customers = new ArrayList<>();
        BufferedReader buff = new BufferedReader(new FileReader(FILE_PATH));

        String line;
        String[] temp;
        Customer customer;

        while ((line = buff.readLine()) != null){
            temp = line.split(",");

            String name = temp[0];
            LocalDate birthDay = ValidatePerson.parseLocalDate(temp[1]);
            String gender = temp[2];
            String idCode = temp[3];
            String phone = temp[4];
            String email = temp[5];
            int customerCode = Integer.parseInt(temp[6]);
            String customerType = temp[7];
            String address = temp[8];

            customer = new Customer(name, birthDay, gender, idCode, phone, email, customerCode, customerType, address);
            customers.add(customer);
        }

        buff.close();
        return customers;
    }
}
