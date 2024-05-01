package pro.sky.demo2.employee;

import java.util.Objects;

import static org.springframework.util.StringUtils.capitalize;

public class Employee {


    private String firstName;
    private String secondName;
    private int sallary;
    private int department;

    public void setSallary(int sallary) {
        this.sallary = sallary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSallary() {
        return sallary;
    }

    public int getDepartment() {
        return department;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;
        return Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getSecondName(), employee.getSecondName());
    }

    public Employee(String firstName, String secondName, int sallary, int department) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.secondName = capitalize(secondName.toLowerCase());
        this.sallary = sallary;
        this.department = department;
    }

    public String getFullName() {
        return firstName + " " + secondName;
    }
    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "EmployeeService{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", sallary='" + sallary + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, sallary, department);
    }
}