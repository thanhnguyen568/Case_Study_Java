package model;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person {
    private int id;
    private String level;
    private String position;
    private int salary;

    public Employee(String name, LocalDate birthday, String gender, String identityCode, String phoneNumber, String email, int id, String level, String position, int salary) {
        super(name, birthday, gender, identityCode, phoneNumber, email);
        this.id = id;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", getName(), getBirthdayStr(getBirthday()), getGender(), getIdentityCode(), getPhoneNumber(), getEmail(), getId(), getLevel(), getPosition(), getSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + super.getName() + '\'' +
                ", level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
