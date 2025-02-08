package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main {

    private ArrayList<Employee> employees;

    public Main() {
        employees = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployeeByName(String name) {
        return employees.stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void insertEmployees(ArrayList<Employee> newEmployees) {
        employees.addAll(newEmployees);
    }

    public Employee removeEmployee(String name) {
        Employee employee = employees.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        if (employee != null) {
            employees.remove(employee);
        }

        return employee;
    }

    public void printEmployeesInformations() {
        for (Employee employee : employees) {
            System.out.println("Informações do Funcionário:\n");

            System.out.println("\tNome: %s\n".formatted(employee.getName()));
            System.out.println("\tData de Nascimento: %s\n".formatted(employee.getFormatedBirthdayDate()));
            System.out.println("\tFunção: %s\n".formatted(employee.getPosition()));
            System.out.println("\tSalário: %s\n".formatted(employee.getFormatedStringSalary()));
        }
    }

    public void printEmployeesInformations(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println("Informações do Funcionário:\n");

            System.out.println("\tNome: %s\n".formatted(employee.getName()));
            System.out.println("\tData de Nascimento: %s\n".formatted(employee.getFormatedBirthdayDate()));
            System.out.println("\tFunção: %s\n".formatted(employee.getPosition()));
            System.out.println("\tSalário: %s\n".formatted(employee.getFormatedStringSalary()));
        }
    }

    public void updateEmployeesSalary(float percentage) {
        for (Employee employee : employees) {
            BigDecimal newSalary = employee.getSalary().multiply(new BigDecimal(1 + percentage)).setScale(2,
                    RoundingMode.HALF_UP);
            employee.setSalary(newSalary);
        }
    }

    public HashMap<String, ArrayList<Employee>> groupEmployeesByPosition() {
        HashMap<String, ArrayList<Employee>> groupedEmployees = new HashMap<String, ArrayList<Employee>>();

        for (Employee employee : employees) {
            String position = employee.getPosition();
            if (!groupedEmployees.containsKey(position)) {
                groupedEmployees.put(position, new ArrayList<>());
            }
            groupedEmployees.get(position).add(employee);
        }

        return groupedEmployees;
    }

    public void printGroupedEmployees(HashMap<String, ArrayList<Employee>> groupedEmployees) {
        for (String position : groupedEmployees.keySet()) {
            System.out.println("Função: " + position);
            for (Employee employee : groupedEmployees.get(position)) {
                System.out.println("\tNome: " + employee.getName());
            }
        }
    }

    public ArrayList<Employee> getEmployeesFilteredByBirthdayMonth(ArrayList<Employee> employees,
            ArrayList<Month> months) {
        ArrayList<Employee> filteredEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            Month birthdayMonth = employee.getBirthdayDate().getMonth();

            if (months.contains(birthdayMonth)) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }

    public Employee getOldestEmployee() {
        ArrayList<Employee> sortedEmployees = new ArrayList<>(employees);
        Collections.sort(sortedEmployees, Comparator.comparing(Employee::getBirthdayDate));
        return sortedEmployees.get(0);
    }

    public void printEmployeeInformations(Employee employee) {
        System.out.println("\tNome: %s\n".formatted(employee.getName()));
        System.out.println("\tData de Nascimento: %s\n".formatted(employee.getFormatedBirthdayDate()));
    }

    public ArrayList<Employee> orderEmployeesByName(ArrayList<Employee> employees) {
        ArrayList<Employee> sortedEmployees = new ArrayList<>(employees);
        Collections.sort(sortedEmployees, Comparator.comparing(Employee::getName));
        return sortedEmployees;
    }

    public String getEmployeesSalarySum() {
        BigDecimal total = new BigDecimal(0);

        for (Employee employee : employees) {
            total = total.add(employee.getSalary());
        }

        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        String formattedTotal = formatter.format(total);

        formattedTotal = formattedTotal.replace(",", "_").replace(".", ",").replace("_", ".");

        return formattedTotal;
    }

    public void printEmployeesSalarySum() {
        System.out.println("Soma dos salários: " + this.getEmployeesSalarySum());
    }

    public BigDecimal getEmployeeSalaryByMinimumSalaryQuantity(Employee employee) {
        BigDecimal MINIMUM_SALARY = new BigDecimal(1212);

        return employee.getSalary()
                .divide(MINIMUM_SALARY, 1, RoundingMode.HALF_UP);
    }

    public void printEmployeesSalaryByMinimumSalaryQuantity() {
        System.out.println("Quantidade de Salários Mínimos dos Funcionários:\n");
        for (Employee employee : employees) {

            System.out.println("\tNome: %s\n".formatted(employee.getName()));
            System.out.println("\tTotal ganho em salários mínimos: %.1f\n"
                    .formatted(this.getEmployeeSalaryByMinimumSalaryQuantity(employee)));
        }
    }

}
