package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    private Employee employee;
    private BigDecimal salary;
    private String position;
    private LocalDate birthdayDate;

    @BeforeEach
    public void setUp() {
        salary = new BigDecimal("5000.00");
        position = "Developer";
        birthdayDate = LocalDate.of(1990, 5, 15);
        employee = new Employee("Joao", birthdayDate, salary, position);
    }

    @Test
    public void shouldGetEmployeeSalary() {
        assertEquals(salary, employee.getSalary());
    }

    @Test
    public void shouldGetEmployeePosition() {
        assertEquals(position, employee.getPosition());
    }

    @Test
    public void shouldSetSalary() {
        BigDecimal newSalary = new BigDecimal("6000.00");
        employee.setSalary(newSalary);
        assertEquals(newSalary, employee.getSalary());
    }

    @Test
    public void shouldSetPosition() {
        String newPosition = "Senior Developer";
        employee.setPosition(newPosition);
        assertEquals(newPosition, employee.getPosition());
    }

    @Test
    public void shouldReturnFormatedSalary() {
        assertEquals("5.000,00", employee.getFormatedStringSalary());

        employee.setSalary(new BigDecimal(1000000.55));
        
        assertEquals("1.000.000,55", employee.getFormatedStringSalary());
    }
}
