package pro.sky.demo2.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.demo2.employee.Employee;
import pro.sky.demo2.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/maxSallary")
    public Employee maxSalary(@RequestParam Integer department) {
        return departmentService.maxSalary(department);
    }

    @GetMapping(path = "/minSallary")
    public Employee minSalary(@RequestParam Integer department) {
        return departmentService.minSalary(department);

    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getByDepartment() {
        return departmentService.getByDepartment();

    }

    @GetMapping(path = "/alldepartment", params = {"department"})
    public Collection<Employee> getByDepartmentAll(@RequestParam int department) {
        return departmentService.getByDepartmentAll(department);
    }
}

