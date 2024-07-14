package pro.sky.demo2.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pro.sky.demo2.employee.Employee;
import pro.sky.demo2.exception.EmployeeNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class DepartmentServiceImplTestsDepartmets {

    private EmployeeServiceImpl employeeService;
    private DepartmentService departmentService;
    private List<Employee> employeeList = List.of(
            new Employee("Иванов", "Иван", 22222, 3),
            new Employee("Сидоров", "Федя", 33333, 3),
            new Employee("Кросс", "Тони", 11111, 1));

    @BeforeEach
    public void init() {
        employeeService = Mockito.mock(EmployeeServiceImpl.class);
        departmentService = new DepartmentServiceImpl(employeeService);
    }

    @Test
    public void byDepartment() {
        when(employeeService.getAll()).thenReturn(employeeList);

        Map<Integer, List<Employee>> employees = departmentService.getByDepartment();
        assertEquals(2, employees.size());
        assertEquals(2, employees.get(3).size());
        assertEquals(1, employees.get(1).size());

    }

    @Test
    public void byDepartmentAll() {
        when(employeeService.getAll()).thenReturn(employeeList);
        Collection<Employee> employees = departmentService.getByDepartmentAll(2);
        assertEquals(0, employees.size());
        when(employeeService.getAll()).thenReturn(employeeList);
        Collection<Employee> employees2 = departmentService.getByDepartmentAll(3);
        assertEquals(2, employees2.size());
        assertEquals(employeeList.stream().findFirst(), employees2.stream().findFirst());

    }

    @Test
    public void byDepartmentSallaryMin() {
        when(employeeService.getAll()).thenReturn(employeeList);
        Employee employees = departmentService.minSalary(3);
        assertEquals(22222, employees.getSallary());
        when(employeeService.getAll()).thenReturn(employeeList);
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.minSalary(2));
    }

    @Test
    public void byDepartmentSallaryMax() {
        when(employeeService.getAll()).thenReturn(employeeList);
        Employee employees = departmentService.maxSalary(3);
        assertEquals(33333, employees.getSallary());
        when(employeeService.getAll()).thenReturn(employeeList);
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.maxSalary(2));
    }
}