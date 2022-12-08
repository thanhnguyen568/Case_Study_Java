package util;

import model.Employee;
import validate.ValidatePerson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadFileEmployeeUtil {

    public static List<Employee> readFile(String FILE_PATH) {
        List<Employee> employees = new ArrayList<>();

        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new FileReader(FILE_PATH));

            String line;
            String[] temp;
            Employee employee;

            while ((line = buff.readLine()) != null) {
                if (!"".equals(line)) {
                    temp = line.split(",");

                    String name = temp[0];
                    LocalDate birthDay = ValidatePerson.parseLocalDate(temp[1]);
                    String gender = temp[2];
                    String idCode = temp[3];
                    String phone = temp[4];
                    String email = temp[5];
                    int id = Integer.parseInt(temp[6]);
                    String level = temp[7];
                    String position = temp[8];
                    int salary = Integer.parseInt(temp[9]);

                    employee = new Employee(name, birthDay, gender, idCode, phone, email, id, level, position, salary);
                    employees.add(employee);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (buff != null) {
                try {
                    buff.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return employees;
    }
}
