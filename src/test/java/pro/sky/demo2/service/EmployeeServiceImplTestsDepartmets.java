package pro.sky.demo2.service;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import pro.sky.demo2.employee.Employee;
import pro.sky.demo2.exception.EmployeeNotFoundException;
import pro.sky.demo2.exception.EmployeeStorageIsFullException;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTestsDepartmets {
	private EmployeeService employeeService = new EmployeeServiceImpl();


	@Test
	public void getAddEmployees() {

		Employee employee = employeeService.addEmployee("vsd", "Dddd", 2, 2);

		assertEquals("Vsd Dddd", employee.getFullName());
		assertEquals(2, employee.getSallary());
		assertEquals(2, employee.getDepartment());
		assertNotEquals("Vsd !", employee.getFullName());
		assertNotEquals("222 Dddd", employee.getFullName());
		assertNotEquals(1, employee.getSallary());
		assertThrows(EmployeeStorageIsFullException.class,()->	employeeService.addEmployee("vsd", "dddd", 5, 2));
	}

	@Test
	public void removeEmployee() {

		employeeService.addEmployee("vsd", "dddd", 5, 2);
		employeeService.addEmployee("qsd", "dddcdd", 2, 2);
		employeeService.removeEmployee("qsd", "dddcdd", 2, 2);
		assertThrows(EmployeeNotFoundException.class, () ->
				employeeService.removeEmployee("qsd", "dddc3dd", 2, 2));
		assertThrows(EmployeeNotFoundException.class, () ->
				employeeService.findEmployee("qsd", "dddcdd", 2, 2));

	}

	@Test
	public void findEmployee() {
		employeeService.addEmployee("vsd", "dddd", 5, 2);
		Employee employee=employeeService.findEmployee("vsd", "dddd", 5, 2);

		assertEquals(("Vsd"),
				 employee.getFirstName());
		assertEquals(("Dddd"),
				employee.getSecondName());
		assertNotEquals("555",
				employee.getSallary());
	}
	@Test
	public void allEmployee() {
		Employee employee1 =employeeService.addEmployee("vsd", "dddd", 5, 2);
		Collection <Employee> employeeCol=employeeService.getAll();
		assertEquals(employee1,employeeCol.stream().findFirst().get());
		assertNotEquals(2,
				employeeCol.size());
		MatcherAssert.assertThat(employeeCol, Matchers.containsInAnyOrder(employee1));
	}
}
