package pro.sky.java.course2.homework25;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.homework25.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.homework25.exception.EmployeeNotFoundException;
import pro.sky.java.course2.homework25.service.EmployeeService;
import pro.sky.java.course2.homework25.service.EmployeeServiceImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    private  final EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    public void shouldThrowExceptionWhenEmployeeIsAlreadyAdded() {
        Employee employee = new Employee("Ivan", "Ivanov", 1, 100_000);
        employeeService.addPerson(employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(), employee.getSalary());

        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.addPerson(employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(), employee.getSalary()));
    }
    @Test
    // почему этот тест не работает? Expected и Actual индентичные
    public void shouldReturnCorrectAddEmployee() {
        Employee employee = new Employee("Ivan", "Petrov", 1, 100_000);
        Employee addedEmployee = employeeService.addPerson(employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(), employee.getSalary());
        assertEquals(employee, addedEmployee);
    }
    @Test
    public void shouldReturnCorrectFindEmployee() {
        Employee employee = new Employee("Ivan", "Petrov", 1, 100_000);
        employeeService.addPerson(employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(), employee.getSalary());
        Employee findEmployee = employeeService.findPerson(employee.getFirstName(), employee.getLastName());
        assertEquals(employee, findEmployee);
    }

    @Test
    public void shouldThrowEmployeeNotFoundException() {
        Employee employee = new Employee("Ivan", "Ivanov", 1, 100_000);

        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.findPerson(employee.getFirstName(), employee.getLastName()));
    }

    @Test
    public void shouldReturnCorrectPrintEmployee() {
        Employee employee = new Employee("Ivan", "Ivanov", 1, 100_000);
        Employee employee1 = new Employee("Ivan", "Petrov", 2, 120_000);
        Employee employee2 = new Employee("Ivan", "Sidorov", 3, 110_000);
        Map<String, Employee> employees = new HashMap<>();
        employees.put(employee.getFirstName() + employee.getLastName(), employee);
        employees.put(employee1.getFirstName() + employee1.getLastName(), employee1);
        employees.put(employee2.getFirstName() + employee2.getLastName(), employee2);

        assertTrue(employees.containsKey(employee.getFirstName() + employee.getLastName()));
        assertTrue(employees.containsKey(employee1.getFirstName() + employee1.getLastName()));
        assertTrue(employees.containsKey(employee2.getFirstName() + employee2.getLastName()));

    }


}
