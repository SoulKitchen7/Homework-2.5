package pro.sky.java.course2.homework25.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework25.Employee;
import pro.sky.java.course2.homework25.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.homework25.exception.EmployeeNotFoundException;
import pro.sky.java.course2.homework25.exception.InvalidInputException;

import java.util.*;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap;

    public EmployeeServiceImpl() {
        employeeMap = new HashMap<>();

    }
    @Override
    public Employee addPerson(String firstName, String lastName, Integer department, Integer salary) {
        validateInput(firstName, lastName);
        String employeeKey = getEmployeeKey(firstName, lastName);
        if (employeeMap.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException("");
        }
        employeeMap.put(employeeKey, new Employee(firstName, lastName, department, salary));
        return employeeMap.get(employeeKey);
    }

    @Override
    public Employee removePerson(String firstName, String lastName) {
        validateInput(firstName, lastName);
        String employeeKey = getEmployeeKey(firstName, lastName);
        if (employeeMap.containsKey(employeeKey)) {
            employeeMap.remove(employeeKey);
            return employeeMap.get(employeeKey);
        }
        throw new EmployeeNotFoundException("");
    }

    @Override
    public Employee findPerson(String firstName, String lastName) {
        validateInput(firstName, lastName);
        String employeeKey = getEmployeeKey(firstName, lastName);
        if (employeeMap.containsKey(employeeKey)) {
            return employeeMap.get(employeeKey);
        }
        throw new EmployeeNotFoundException("");
    }
    @Override
    public Map <String, Employee> printEmployee() {
        return printEmployee();
    }

    private void validateInput(String firstName, String lastName) {

        if (!(StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName)));
    }

    private String getEmployeeKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}
