package pro.sky.java.course2.homework25.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework25.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Integer employeeSumSalary(Integer departmentId) {
        return employeeService.printEmployee().values().stream()
                .filter(e -> e.getDepartmentId().equals(departmentId))
                .mapToInt (Employee ::getSalary)
                .sum();

    }
    @Override
    public Integer employeeWithMaxSalary(Integer departmentId) {
        return employeeService.printEmployee().values().stream()
                .filter(e -> e.getDepartmentId().equals(departmentId))
                .map (Employee ::getSalary)
                .max(Integer::compareTo)
                .orElse(null);
    }
    @Override
    public Integer employeeWithMinSalary(Integer departmentId) {
        return employeeService.printEmployee().values().stream()
                .filter(e -> e.getDepartmentId().equals(departmentId))
                .map (Employee ::getSalary)
                .min(Integer::compareTo)
                .orElse(null);
    }

    @Override
    public List<Employee> allEmployeeDepartment(Integer departmentId) {
        return employeeService.printEmployee().values().stream()
                .filter(e -> e.getDepartmentId().equals(departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployee() {
        return employeeService.printEmployee().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
