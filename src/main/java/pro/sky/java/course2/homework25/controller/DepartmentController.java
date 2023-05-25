package pro.sky.java.course2.homework25.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.homework25.Employee;
import pro.sky.java.course2.homework25.service.DepartmentService;
import pro.sky.java.course2.homework25.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController (DepartmentService departmentService) {

        this.departmentService = departmentService;
    }
    @GetMapping("{id}/salary/sum")
    public Integer employeeSumSalary(@PathVariable("id") Integer departmentId) {
        return departmentService.employeeSumSalary(departmentId);
    }
    @GetMapping("{id}/salary/max")
    public Integer employeeWithMaxSalary(@PathVariable("id") Integer departmentId) {
        return departmentService.employeeWithMaxSalary(departmentId);
    }
    @GetMapping("/{id}/salary/min")
    public Integer employeeWithMinSalary(@PathVariable("id") Integer departmentId) {
        return departmentService.employeeWithMinSalary(departmentId);
    }
    @GetMapping ("/{id}/employees")
    public List<Employee> employeeByDepartment (@PathVariable ("id") Integer departmentId) {
        return departmentService.allEmployeeDepartment(departmentId);
    }

    @GetMapping ("/employees")
    public Map<Integer, List<Employee>> allEmployee () {
        return departmentService.allEmployee();
    }
}
