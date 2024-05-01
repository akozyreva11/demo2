package pro.sky.demo2.service;

import org.springframework.stereotype.Service;
import pro.sky.demo2.employee.Employee;
import pro.sky.demo2.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeServiceImpl employeeService;
    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Collection<Employee> getByDepartmentAll(int department) {
        return employeeService
                .getAll()
                .stream()
                .filter(employee -> employee.getDepartment()==department)
                .sorted (Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSecondName))
                .collect(toList());
    }

    @Override
    public Collection<Employee> getAll() {
        return List.of();
    }

    @Override
    public Map<Integer, List<Employee>> getByDepartment() {
        return employeeService
                .getAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSecondName))
                .collect(groupingBy(Employee::getDepartment));
    }
    @Override
    public Employee maxSalary(int department) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSallary)).orElseThrow(() -> new EmployeeNotFoundException("Мы не смогли найтм,то что вы искали"));
    }

    @Override
    public Employee minSalary(int department) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSallary)).orElseThrow(() -> new EmployeeNotFoundException("Мы не смогли найтм,то что вы искали"));
    }

}


