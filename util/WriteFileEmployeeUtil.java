package util;

import model.Employee;

import java.io.*;
import java.util.List;

public class WriteFileEmployeeUtil {
    private static void writeFile(String path, String data) {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(path);
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void writeEmployeeFile(String path, List<Employee> employees) {
        String data = "";
        for (Employee employee : employees) {
            data += employee.getInfo();
        }

        writeFile(path, data);
    }
}
