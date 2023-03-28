package pro.sky.java.course2.homework25.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework25.Employee;
import pro.sky.java.course2.homework25.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.homework25.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        employeeList = new ArrayList<>();

    }

    @Override
    public Employee addPerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("");
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee removePerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("");
    }

    @Override
    public Employee findPerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("");
    }
    @Override
    public List<Employee> printEmployee() {
        return new ArrayList<>(employeeList);
    }
}
