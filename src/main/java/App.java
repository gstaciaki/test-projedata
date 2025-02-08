import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import model.Employee;
import model.Main;

public class App {
    public static void main(String[] args) {
        Main main = new Main();
        /*
         * Insere todos funcionários
         */
        ArrayList<Employee> employees = new ArrayList<>(List.of(
                new Employee("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Employee("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new Employee("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Employee("Miguel", LocalDate.of(1986, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Employee("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new Employee("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Employee("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new Employee("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new Employee("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Employee("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")));

        main.insertEmployees(employees);

        System.out.println("Lista de Funcionários:");
        main.printEmployeesInformations();
        System.out.println("");

        /*
         * Remove o funcionário João e lista as informações do mesmo
         */

        Employee removedEmployee = main.removeEmployee("João");
        System.out.println("Lista de Funcionários após remoção:");
        main.printEmployeeInformations(removedEmployee);
        System.out.println("");

        /*
         * Imprime todos os funcionários com suas informações formatadas
         */

        main.printEmployeesInformations();

        /*
         * Atualiza os salário dos funcionários em 10%
         */

        main.updateEmployeesSalary(0.10f);

        /*
         * Agrupa os funcionários por função e imprime a lista
         */

        HashMap<String, ArrayList<Employee>> groupedEmployees = main.groupEmployeesByPosition();
        System.out.println("Lista de Funcionários Agrupados por Função:");
        main.printGroupedEmployees(groupedEmployees);
        System.out.println("");

        /*
         * Imprime os funcionários que fazem aniversário no mês 10 e 12
         */

        System.out.println("Funcionários que fazem aniversário no mês 10 e 12:");
        main.printEmployeesInformations(main.getEmployeesFilteredByBirthdayMonth(
                employees,
                new ArrayList<>(Arrays.asList(Month.OCTOBER, Month.DECEMBER))));
        System.out.println("");

        /*
         * Imprime o funcionário mais velho na lista
         */

        System.out.println("Funcionário Mais Velho:");
        main.printEmployeeInformations(main.getOldestEmployee());

        /*
         * Imprime a lista de funcionários em ordem alfabética
         */

        System.out.println("Lista de Funcionários em ordem alfabética:");
        main.printEmployeesInformations(main.orderEmployeesByName(employees));

        /*
         * Imprime o valor total da soma dos salários
         */

        main.printEmployeesSalarySum();

        /*
         * Imprime quantos salários mínimos ganha cada funcionário
         */

        main.printEmployeesSalaryByMinimumSalaryQuantity();
    }
}