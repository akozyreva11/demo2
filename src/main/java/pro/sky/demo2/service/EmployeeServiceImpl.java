package pro.sky.demo2.service;

import org.springframework.stereotype.Service;
import pro.sky.demo2.employee.Employee;
import pro.sky.demo2.exception.EmployeeAlreadyAddedException;
import pro.sky.demo2.exception.EmployeeNotFoundException;
import pro.sky.demo2.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>(List.of(
            new Employee(
                    "Иван",
                    "Иванов"
            ),
            new Employee(
                    "Семён",
                    "Петров"
            ),
            new Employee(
                    "Федя",
                    "Фёдоров"
            ),
            new Employee(
                    "Алексей",
                    "Сидоров"
            )
    ));

    //Добавить сотрудника.

    @Override
    public Employee add(Employee employee) {
        final int max = 3;
        if (max > employees.size()) {
            throw new EmployeeStorageIsFullException("ошибка, значений уже слишком много");
        }
        if (employees.contains(employee)) {
            throw new EmployeeNotFoundException("такой сотрудник уже найден");
        }
         employees.add(employee);
        return employee;
    }

    //Удалить сотрудника.
    @Override
    public Employee remove(Employee employee) throws EmployeeNotFoundException {
        employees.remove(employee);
        return employee;
    }

    //Найти сотрудника.
    @Override
    public Employee find(Employee employee) throws EmployeeAlreadyAddedException {
        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeAlreadyAddedException("ошибка ,такого чувака нет");

        }
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }
}