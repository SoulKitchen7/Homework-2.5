package pro.sky.java.course2.homework25.service;

import pro.sky.java.course2.homework25.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeService  {

    Employee addPerson(String firstName, String lastName, Integer department, Integer salary);

    Employee removePerson(String firstName, String lastName);
    Employee findPerson(String firstName, String lastName);

    Map<String, Employee> printEmployee();

}
