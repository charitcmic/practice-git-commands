package com.cmic.firstapp;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code EmployeeList} class manages a collection of {@link Employee} objects.
 * It provides methods to add employees, retrieve employee names, sort employees by age,
 * filter employees by salary, and access the list of employees.
 *
 * <p>Features:</p>
 * <ul>
 *   <li>Add an employee to the list.</li>
 *   <li>Retrieve employee names as an array (with or without streams).</li>
 *   <li>Get a list of employees sorted by age.</li>
 *   <li>Filter employees whose salary is greater than a specified amount.</li>
 *   <li>Get a copy of the current list of employees.</li>
 * </ul>
 */
public class EmployeeList {
    
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String[] getEmployeeNames() {
        String[] names = new String[employees.size()];
        for (int i = 0; i < employees.size(); i++) {
            names[i] = employees.get(i).getName();
        }
        return names;
    }  

    public String[] getEmployeeNamesWithStreams() {
        return employees.stream()
                        .map(Employee::getName)
                        .toArray(String[]::new);
    }

    public List<Employee> getEmployeesSortedByAge() {
        return employees.stream()
                        .sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                        .toList();
    }

    public List<Employee> getEmployeesWithSalaryGreaterThan(int salary) {
        return employees.stream()
                        .filter(e -> e.getSalary() > salary)
                        .sorted((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()))
                        .toList();
    }

}
