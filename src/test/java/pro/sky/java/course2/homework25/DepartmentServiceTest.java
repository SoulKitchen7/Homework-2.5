package pro.sky.java.course2.homework25;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.homework25.service.DepartmentService;
import pro.sky.java.course2.homework25.service.DepartmentServiceImpl;
import pro.sky.java.course2.homework25.service.EmployeeService;
import pro.sky.java.course2.homework25.service.EmployeeServiceImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void shouldReturnEmployeeWithMaxSalary() {
        final int departmentId = 1;
        Employee employee = new Employee("Ivan", "Ivanov", departmentId, 100_000);
        Employee employee1 = new Employee("Ivan", "Petrov", departmentId, 120_000);
        Employee employee2 = new Employee("Ivan", "Sidorov", departmentId, 110_000);

        Map<String, Employee> employees = new HashMap<>();
        employees.put(employee.getFirstName() + employee.getLastName(), employee);
        employees.put(employee1.getFirstName() + employee1.getLastName(), employee1);
        employees.put(employee2.getFirstName() + employee2.getLastName(), employee2);

        when(employeeService.printEmployee()).thenReturn(employees);

        Integer employeeWithMaxSalary = departmentService.employeeWithMaxSalary(departmentId);
        assertEquals(employee1, employeeWithMaxSalary);
    }
    @Test
    public void shouldReturnEmployeeWithMinSalary() {
        final int departmentId = 1;
        Employee employee = new Employee("Ivan", "Ivanov", departmentId, 100_000);
        Employee employee1 = new Employee("Ivan", "Petrov", departmentId, 120_000);
        Employee employee2 = new Employee("Ivan", "Sidorov", departmentId, 110_000);

        Map<String, Employee> employees = new HashMap<>();
        employees.put(employee.getFirstName() + employee.getLastName(), employee);
        employees.put(employee1.getFirstName() + employee1.getLastName(), employee1);
        employees.put(employee2.getFirstName() + employee2.getLastName(), employee2);

        when(employeeService.printEmployee()).thenReturn(employees);

        Integer employeeWithMinSalary = departmentService.employeeWithMinSalary(departmentId);
        assertEquals(employee, employeeWithMinSalary);
    }
    @Test
    public void shouldReturnSumSalary() {
        final int departmentId = 1;
        final int sumSalary = 300_000;

        Employee employee = new Employee("Ivan", "Ivanov", departmentId, 100_000);
        Employee employee1 = new Employee("Ivan", "Petrov", departmentId, 100_000);
        Employee employee2 = new Employee("Ivan", "Sidorov", departmentId, 100_000);

        Map<String, Employee> employees = new HashMap<>();
        employees.put(employee.getFirstName() + employee.getLastName(), employee);
        employees.put(employee1.getFirstName() + employee1.getLastName(), employee1);
        employees.put(employee2.getFirstName() + employee2.getLastName(), employee2);

        when(employeeService.printEmployee()).thenReturn(employees);

        Integer employeeSumSalary = departmentService.employeeSumSalary(departmentId);
        assertEquals(sumSalary, employeeSumSalary);
    }

    @Test
    public void shouldReturnEmployeeByDepartment() {
        final int departmentId = 1;
        Employee employee = new Employee("Ivan", "Ivanov", departmentId, 100_000);
        Employee employee1 = new Employee("Ivan", "Petrov", departmentId, 120_000);
        Employee employee2 = new Employee("Ivan", "Sidorov", departmentId, 110_000);

        Map<String, Employee> employees = new HashMap<>();
        employees.put(employee.getFirstName() + employee.getLastName(), employee);
        employees.put(employee1.getFirstName() + employee1.getLastName(), employee1);
        employees.put(employee2.getFirstName() + employee2.getLastName(), employee2);

        when(employeeService.printEmployee()).thenReturn(employees);

        assertTrue(employees.containsKey(employee.getFirstName() + employee.getLastName()));
        assertTrue(employees.containsKey(employee1.getFirstName() + employee1.getLastName()));
        assertTrue(employees.containsKey(employee2.getFirstName() + employee2.getLastName()));

    }
    @Test
    // не могу понять почему этот тест не работает
    public void shouldReturnAllEmployees() {

        Employee employee = new Employee("Ivan", "Ivanov", 1, 100_000);
        Employee employee1 = new Employee("Ivan", "Petrov", 2, 100_000);
        Employee employee2 = new Employee("Ivan", "Sidorov", 3, 100_000);

        Map<String, Employee> employees = new HashMap<>();
        employees.put(employee.getFirstName() + employee.getLastName(), employee);
        employees.put(employee1.getFirstName() + employee1.getLastName(), employee1);
        employees.put(employee2.getFirstName() + employee2.getLastName(), employee2);

        when(employeeService.printEmployee()).thenReturn(employees);

        assertTrue(employees.containsKey(employee.getFirstName() + employee.getLastName()));
        assertTrue(employees.containsKey(employee1.getFirstName() + employee1.getLastName()));
        assertTrue(employees.containsKey(employee2.getFirstName() + employee2.getLastName()));

    }
    @Test
    public void shouldReturnNullWhenDepartmentIsEmpty() {

        when(employeeService.printEmployee()).thenReturn(Collections.emptyMap());

        Integer employeeWithMaxSalary = departmentService.employeeWithMaxSalary(1);
        assertNull(employeeWithMaxSalary);
    }

}
