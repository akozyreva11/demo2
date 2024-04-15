package pro.sky.demo2.service;


import org.springframework.stereotype.Service;
import pro.sky.demo2.employee.Employee;
import pro.sky.demo2.exception.EmployeeAlreadyAddedException;
import pro.sky.demo2.exception.EmployeeNotFoundException;
import pro.sky.demo2.exception.EmployeeStorageIsFullException;

import java.util.Collection;

@Service
public interface EmployeeService {

    Employee add(Employee employee) throws EmployeeAlreadyAddedException;

    //Удалить сотрудника.
    Employee remove(Employee employee) throws EmployeeNotFoundException;

    //Найти сотрудника.
    Employee find(Employee employee) throws EmployeeStorageIsFullException;

    Collection<Employee> getAll();


}
