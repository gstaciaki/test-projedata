package model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {

    private Main main;

    @BeforeEach
    public void setUp() {
        main = new Main();
    }

    @Test
    public void shouldInsertEmployeeListIntoArrayList() {
        ArrayList<Employee> newEmployees = new ArrayList<>();
        newEmployees.add(new Employee("Alice", LocalDate.of(1990, 5, 15), new BigDecimal("3000"), "Manager"));
        main.insertEmployees(newEmployees);

        assertEquals(newEmployees, main.getEmployees());
    }

    @Test
    public void shouldRemoveEmployeeFromList() {
        Employee employee = new Employee("John", LocalDate.of(1999, 10, 20), new BigDecimal("2500"), "Developer");
        main.insertEmployees(new ArrayList<>(java.util.List.of(employee)));

        main.removeEmployee(employee.getName());

        assertTrue(main.getEmployees().isEmpty());
    }

    @Test
    public void shouldUpdateEmployeesSalary() {
        Employee employee = new Employee("John", LocalDate.of(1999, 10, 20), new BigDecimal("2500"), "Developer");
        main.insertEmployees(new ArrayList<>(java.util.List.of(employee)));

        main.updateEmployeesSalary(0.10f);

        assertEquals(new BigDecimal("2750.00"), employee.getSalary());
    }

    @Test
    public void shouldGroupEmployeesByPosition() {
        Employee dev1 = new Employee("John", LocalDate.of(1999, 10, 20), new BigDecimal("2500"), "Developer");
        Employee dev2 = new Employee("Jane", LocalDate.of(1985, 3, 10), new BigDecimal("3200"), "Developer");
        Employee manager = new Employee("Alice", LocalDate.of(1990, 5, 15), new BigDecimal("4000"), "Manager");
        main.insertEmployees(new ArrayList<>(java.util.List.of(dev1, dev2, manager)));

        HashMap<String, ArrayList<Employee>> grouped = main.groupEmployeesByPosition();

        assertEquals(2, grouped.get("Developer").size());
        assertEquals(1, grouped.get("Manager").size());
    }

    @Test
    public void shouldFilterEmployeesByBirthdayMonth() {
        Employee emp1 = new Employee("John", LocalDate.of(1999, 10, 20), new BigDecimal("2500"), "Developer");
        Employee emp2 = new Employee("Jane", LocalDate.of(1985, 3, 10), new BigDecimal("3200"), "Developer");
        ArrayList<Employee> employees = new ArrayList<>(java.util.List.of(emp1, emp2));

        ArrayList<Employee> filtered = main.getEmployeesFilteredByBirthdayMonth(employees,
                new ArrayList<>(java.util.List.of(Month.OCTOBER)));

        assertEquals(1, filtered.size());
        assertEquals("John", filtered.get(0).getName());
    }

    @Test
    public void shouldReturnOldestEmployee() {
        Employee emp1 = new Employee("John", LocalDate.of(1999, 10, 20), new BigDecimal("2500"), "Developer");
        Employee emp2 = new Employee("Jane", LocalDate.of(1985, 3, 10), new BigDecimal("3200"), "Developer");
        ArrayList<Employee> employees = new ArrayList<>(java.util.List.of(emp1, emp2));
        main.insertEmployees(employees);

        Employee oldest = main.getOldestEmployee();

        assertEquals("Jane", oldest.getName());
    }

    @Test
    public void shouldOrderEmployeesByName() {
        Employee emp1 = new Employee("Charlie", LocalDate.of(1999, 10, 20), new BigDecimal("2500"), "Developer");
        Employee emp2 = new Employee("Alice", LocalDate.of(1985, 3, 10), new BigDecimal("3200"), "Manager");
        ArrayList<Employee> employees = new ArrayList<>(java.util.List.of(emp1, emp2));

        ArrayList<Employee> sorted = main.orderEmployeesByName(employees);

        assertEquals("Alice", sorted.get(0).getName());
        assertEquals("Charlie", sorted.get(1).getName());
    }

    @Test
    public void shouldReturnCorrectTotalSalary() {
        Employee emp1 = new Employee("John", LocalDate.of(1999, 10, 20), new BigDecimal("2500"), "Developer");
        Employee emp2 = new Employee("Jane", LocalDate.of(1985, 3, 10), new BigDecimal("3200"), "Developer");
        main.insertEmployees(new ArrayList<>(java.util.List.of(emp1, emp2)));

        assertEquals("5.700,00", main.getEmployeesSalarySum());
    }

    @Test
    public void shouldReturnEmployeeSalaryInMinimumSalaries() {
        Employee emp1 = new Employee("John", LocalDate.of(1999, 10, 20), new BigDecimal("2500"), "Developer");
        BigDecimal minSalaries = main.getEmployeeSalaryByMinimumSalaryQuantity(emp1);

        assertEquals(new BigDecimal(2.1).setScale(1,
                RoundingMode.DOWN), minSalaries);
    }
}
