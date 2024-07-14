package pro.sky.demo2.service;

import org.springframework.stereotype.Service;
import pro.sky.demo2.employee.Employee;
import pro.sky.demo2.exception.EmployeeInvalidExeption;
import pro.sky.demo2.exception.EmployeeNotFoundException;
import pro.sky.demo2.exception.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }


    @Override
    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public Employee findEmployee(String firstName, String secondName, int sallary, int department) {
        if (!isAlpha(firstName) && !isAlpha(secondName)) {
            throw new EmployeeInvalidExeption();
        }
        Employee employee = new Employee(firstName, secondName, sallary, department);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Такой человек не найден");
    }


    @Override
    public Employee removeEmployee(String firstName, String secondName, int sallary, int department) {
        if (!isAlpha(firstName) && !isAlpha(secondName)) {
            throw new EmployeeInvalidExeption();
        }
        Employee employee = new Employee(firstName, secondName, sallary, department);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Такой человек не найден");
    }


    @Override
    public Employee addEmployee(String firstName, String secondName, int sallary, int department) {
        if (!isAlpha(firstName) && !isAlpha(secondName)) {
            throw new EmployeeInvalidExeption();
        }
        Employee employee = new Employee(firstName, secondName, sallary, department);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeStorageIsFullException();

        }
        employees.put(employee.getFullName(), employee);
        return (employee);
    }

}