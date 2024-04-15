package pro.sky.demo2.service;

import org.springframework.stereotype.Service;
import pro.sky.demo2.employee.Employee;
import pro.sky.demo2.exception.EmployeeAlreadyAddedException;
import pro.sky.demo2.exception.EmployeeNotFoundException;
import pro.sky.demo2.exception.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeService {



    Map<String, Employee> employees;

    public EmployeeServiceImpl() {this.employees = new HashMap<>();
    }

    //Удалить сотрудника.
    @Override
    public Employee remove(Employee employee) throws EmployeeNotFoundException {
        employees.remove(employee.getSecondyName());
        return employee;
    }
    @Override
    public Employee add(Employee employee) throws EmployeeNotFoundException {
        if (employees.size() < 3) {
            employees.put(employee.getSecondyName(), employee);
            return (employee);
        } else {
            throw new EmployeeStorageIsFullException("ошибка, значений уже слишком много");
        }
    }
        //Найти сотрудника.
        @Override
        public Employee find (Employee employee) throws EmployeeAlreadyAddedException {
            if (employees.containsKey(employee.getSecondyName())) {
                return employee;
            } else {
                throw new EmployeeAlreadyAddedException("ошибка ,такого чувака нет");
            }
        }

    @Override
    public Collection<Employee> getAll() {
        return (Collections.unmodifiableCollection(employees.values()));
    }
}
