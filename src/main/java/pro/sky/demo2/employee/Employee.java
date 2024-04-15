package pro.sky.demo2.employee;

import java.util.Objects;

public class Employee {


private String firstName;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;
        return Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getSecondName(), employee.getSecondName());
    }

    private String secondName;

public Employee(String firstName, String secondName) {
    this.firstName = firstName;
    this.secondName = secondName;
}

public String getSecondName() {
    return secondName;
}

public String getFirstName() {
    return firstName;
}
    public String getSecondyName() {
        return firstName + " " + secondName;
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
            '}';
}

@Override
public int hashCode() {
    return Objects.hash(firstName, secondName);
}
}