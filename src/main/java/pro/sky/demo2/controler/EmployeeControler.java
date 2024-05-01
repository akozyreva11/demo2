package pro.sky.demo2.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.demo2.employee.Employee;
import pro.sky.demo2.service.EmployeeService;

import java.util.Collection;

//http://localhost:8080/employee/add?firstName=аплпала&secondName=пдопррпдолпр&sallary=3322223&department=1
@RestController
@RequestMapping(path = "/employee")
public class EmployeeControler {
    private final EmployeeService employeeService;

    public EmployeeControler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/allEmployees")
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                   @RequestParam String secondName,
                                   @RequestParam int sallary,
                                   @RequestParam int department) {
        Employee employee = new Employee(
                firstName,
                secondName,
                sallary,
                department
        );
        return employeeService.removeEmployee(firstName,secondName,sallary,department);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String firstName,
                                 @RequestParam String secondName,
                                 @RequestParam int sallary,
                                 @RequestParam int department) {
        Employee employee = new Employee(
                firstName,
                secondName,
                sallary,
                department
        );
        return employeeService.findEmployee(firstName,secondName,sallary,department);
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String secondName,
                                @RequestParam int sallary,
                                @RequestParam int department) {
        Employee employee = new Employee(
                firstName,
                secondName,
                sallary,
                department
        );
        return employeeService.addEmployee(firstName,secondName,sallary,department);
    }

    @GetMapping(path = "/all")
    public Collection<Employee> all(){
    return employeeService.getAll();  }
}