package pro.sky.java.course2.homework25.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.homework25.Employee;
import pro.sky.java.course2.homework25.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.homework25.exception.EmployeeNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addPerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.addPerson(firstName, lastName);
    }
    @GetMapping("/remove")
    public Employee removePerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.removePerson(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee findPerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.findPerson(firstName, lastName);
    }

    @GetMapping
    public List<Employee> printEmployee() {
        return employeeService.printEmployee();
    }
    @ExceptionHandler
    public ResponseEntity<String> handleEmployeeAlreadyAddedException(EmployeeAlreadyAddedException e) {
        return new ResponseEntity<>("Такой сотрудник уже существует", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        return new ResponseEntity<>("Сотрудник не найден", HttpStatus.NOT_FOUND);
    }
}
