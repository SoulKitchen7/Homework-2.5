package pro.sky.java.course2.homework25.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework25.Employee;
import pro.sky.java.course2.homework25.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.homework25.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeMap;
    private Integer department;
    private Integer salary;

    public EmployeeServiceImpl() {
        employeeMap = new HashMap<>();

    }
    @Override
    public Employee addPerson(String firstName, String lastName, Integer department, Integer salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeMap.containsKey(employee.getId())) {
            throw new EmployeeAlreadyAddedException("");
        }
        employeeMap.put(employee.getId().toString(), employee);
        return employee;
    }

    @Override
    public Employee removePerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeMap.containsKey(employee.getId())) {
            employeeMap.remove(employee.getId());
            return employee;
        }
        throw new EmployeeNotFoundException("");
    }

    @Override
    public Employee findPerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeMap.containsKey(employee.getId())) {
            return employeeMap.get(employee.getId());
        }
        throw new EmployeeNotFoundException("");
    }
    @Override
    public Collection<Employee> printEmployee() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }
}
