package pro.sky.demo2.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.demo2.employee.Employee;
import pro.sky.demo2.service.EmployeeService;

import java.util.List;


@RestController
@RequestMapping(path = "/employee")
public class EmployeeControler {

    private final EmployeeService employeeService;

    public EmployeeControler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(path = "/find")
    //http://localhost:8080/employee/find?firstName=Иванова Иина
    public Employee findEmployee(@RequestParam String firstName,
                               @RequestParam String secondName) {
        Employee employee = new Employee(
                firstName,
                secondName
        );
        return employeeService.find(employee);
    }
    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }


    //http://localhost:8080/employee/add?num1=7&num2=7
    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName,
                              @RequestParam String secondName) {
        Employee employee = new Employee(
                firstName,
                secondName
        );
        return employeeService.add(employee);
    }

    //http://localhost:8080/employee/remove?num1=7&num2=7
    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                 @RequestParam String secondName) {
        Employee employee = new Employee(
                firstName,
                secondName
        );
        return employeeService.remove(employee);
    }
}