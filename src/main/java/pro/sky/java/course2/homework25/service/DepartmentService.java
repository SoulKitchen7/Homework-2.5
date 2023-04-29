package pro.sky.java.course2.homework25.service;

import pro.sky.java.course2.homework25.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee employeeWithMaxSalary (Integer department);
    Employee employeeWithMinSalary (Integer department);
    List<Employee> allEmployeeDepartment (Integer department);
    Map<Integer, List <Employee>> allEmployee ();

}
