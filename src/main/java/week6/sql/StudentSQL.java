package week6.sql;

import java.util.Date;

public class StudentSQL {

    int id;
    String fullName;
    int age;
    Date birthDate;
    double salary;
    int addressId;

    public StudentSQL() {
    }

    public StudentSQL(int id, String fullName, int age, Date birthDate, double salary, int addressId) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.birthDate = birthDate;
        this.salary = salary;
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "StudentSQL{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                ", addressId=" + addressId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
