package pro.sky.demo2.service;

import pro.sky.demo2.employee.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Collection<Employee> getAll();

    Map<Integer, List<Employee>> getByDepartment();

    Employee maxSalary(int department);

    Employee minSalary(int department);

    Collection<Employee> getByDepartmentAll(int department);
}
