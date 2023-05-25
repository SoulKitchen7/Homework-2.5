package pro.sky.java.course2.homework25.service;

import pro.sky.java.course2.homework25.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Integer employeeWithMaxSalary (Integer department);
    Integer employeeWithMinSalary (Integer department);
    Integer employeeSumSalary (Integer department);
    List<Employee> allEmployeeDepartment (Integer department);
    Map<Integer, List <Employee>> allEmployee ();

}
