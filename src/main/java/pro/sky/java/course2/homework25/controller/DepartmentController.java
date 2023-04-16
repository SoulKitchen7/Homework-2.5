package pro.sky.java.course2.homework25.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.homework25.Employee;
import pro.sky.java.course2.homework25.service.DepartmentService;
import pro.sky.java.course2.homework25.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController (DepartmentService departmentService) {

        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee employeeWithMaxSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.employeeWithMaxSalary(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee employeeWithMinSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.employeeWithMinSalary(departmentId);
    }
    @GetMapping ("/all")
    public List<Employee> employeeByDepartment (@RequestParam ("departmentId") Integer departmentId) {
        return departmentService.allEmployeeDepartment(departmentId);
    }

    @GetMapping ("/all/by-department")
    public Map<Integer, List<Employee>> allEmployee () {
        return departmentService.allEmployee();
    }
}
