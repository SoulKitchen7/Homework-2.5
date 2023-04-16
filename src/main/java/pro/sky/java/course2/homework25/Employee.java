package pro.sky.java.course2.homework25;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private Integer departmentId;
    private Integer salary;
    private static Integer counter=0;
    private Integer id;

    public Employee(String firstName, String lastName, Integer department, Integer salary) {
        id = ++ counter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(departmentId, employee.departmentId) && Objects.equals(salary, employee.salary) && Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentId, salary, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
