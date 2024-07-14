package pro.sky.demo2.service;


import org.springframework.stereotype.Service;
import pro.sky.demo2.employee.Employee;

import java.util.Collection;

@Service
public interface EmployeeService {


    Collection<Employee> getAll();

    Employee findEmployee(String firstName, String secondName, int sallary, int department);

    Employee removeEmployee(String firstName, String secondName, int sallary, int department);

    Employee addEmployee(String firstName, String secondName, int sallary, int department);
}
