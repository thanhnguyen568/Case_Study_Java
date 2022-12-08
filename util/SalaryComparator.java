package util;

import model.Employee;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee first, Employee second) {
        int result = first.getName().compareTo(second.getName());
        if (result == 0) {
            return (first.getSalary() - second.getSalary());
        }
        return result;
    }

//    @Override
//    public int compare(Employee first, Employee second) {
//        if (first.getName().equals(second.getName())) {
//            return (first.getSalary() - second.getSalary());
//        }
//        return 1;
//    }
}
