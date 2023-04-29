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
    public Employee employeeWithMaxSalary(Integer departmentId) {
        Collection <Employee> employees = employeeService.printEmployee();
        return employees.stream()
                .filter(e -> e.getDepartmentId()==departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .get();
    }
    @Override
    public Employee employeeWithMinSalary(Integer departmentId) {

        Collection <Employee> employees = employeeService.printEmployee();
        return employees.stream()
                .filter(e -> e.getDepartmentId()==departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public List<Employee> allEmployeeDepartment(Integer departmentId) {
        Collection <Employee> employees = employeeService.printEmployee();
        return employees.stream()
                .filter(e -> e.getDepartmentId()==departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployee() {
        Collection <Employee> employees = employeeService.printEmployee();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
