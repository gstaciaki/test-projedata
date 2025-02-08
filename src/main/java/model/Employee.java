package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class Employee extends People {
    private BigDecimal salary;
    private String position;

    public Employee(String name, LocalDate birthdayDate, BigDecimal salary, String position) {
        super(name, birthdayDate);
        this.salary = salary;
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal newSalary) {
        salary = newSalary;
    }

    public String getFormatedStringSalary() {
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        String formattedSalary = formatter.format(salary);

        formattedSalary = formattedSalary.replace(",", "_").replace(".", ",").replace("_", ".");

        return formattedSalary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String newPosition) {
        position = newPosition;
    }
}
