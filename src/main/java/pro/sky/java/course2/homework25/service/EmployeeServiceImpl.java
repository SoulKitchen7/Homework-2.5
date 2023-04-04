package pro.sky.java.course2.homework25.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework25.Employee;
import pro.sky.java.course2.homework25.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.homework25.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeMap;

    public EmployeeServiceImpl() {
        employeeMap = new HashMap<>();

    }

    @Override
    public Employee addPerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("");
        }
        employeeMap.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removePerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(employee.getFullName())) {
            employeeMap.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException("");
    }

    @Override
    public Employee findPerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(employee.getFullName())) {
            return employeeMap.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("");
    }
    @Override
    public Collection<Employee> printEmployee() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }
}
