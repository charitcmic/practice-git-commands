
package com.cmic.firstapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link EmployeeList} class.
 * <p>
 * This test class verifies the following functionalities of EmployeeList:
 * <ul>
 *     <li>Adding employees and retrieving their names.</li>
 *     <li>Retrieving employee names using streams.</li>
 *     <li>Sorting employees by age.</li>
 *     <li>Filtering employees by salary greater than a specified amount.</li>
 *     <li>Handling cases where no employees match the salary filter.</li>
 *     <li>Ensuring the employee list updates correctly when new employees are added.</li>
 * </ul>
 * <p>
 * The test data includes three employees: Alice (age 30, salary 5000), Bob (age 25, salary 6000), and Charlie (age 35, salary 4000).
 * Additional employees may be added in specific test cases.
 */
class EmployeeListTest {

    private EmployeeList employeeList;

    @BeforeEach
    void setUp() {
        employeeList = new EmployeeList();
        employeeList.addEmployee(new Employee("Alice", 30, 5000));
        employeeList.addEmployee(new Employee("Bob", 25, 6000));
        employeeList.addEmployee(new Employee("Charlie", 35, 4000));
    }

    @Test
    void testAddEmployeeAndGetEmployeeNames() {
        String[] names = employeeList.getEmployeeNames();
        assertArrayEquals(new String[]{"Alice", "Bob", "Charlie"}, names);
    }

    @Test
    void testGetEmployeeNamesWithStreams() {
        String[] names = employeeList.getEmployeeNamesWithStreams();
        assertArrayEquals(new String[]{"Alice", "Bob", "Charlie"}, names);
    }

    @Test
    void testGetEmployeesSortedByAge() {
        List<Employee> sorted = employeeList.getEmployeesSortedByAge();
        assertEquals(3, sorted.size());
        assertEquals("Bob", sorted.get(0).getName());
        assertEquals("Alice", sorted.get(1).getName());
        assertEquals("Charlie", sorted.get(2).getName());
    }

    @Test
    void testGetEmployeesWithSalaryGreaterThan() {
        List<Employee> filtered = employeeList.getEmployeesWithSalaryGreaterThan(4500);
        assertEquals(2, filtered.size());
        assertEquals("Alice", filtered.get(0).getName());
        assertEquals("Bob", filtered.get(1).getName());
    }

    @Test
    void testGetEmployeesWithSalaryGreaterThanNoMatch() {
        List<Employee> filtered = employeeList.getEmployeesWithSalaryGreaterThan(10000);
        assertTrue(filtered.isEmpty());
    }

    @Test
    void testAddEmployeeUpdatesList() {
        employeeList.addEmployee(new Employee("David", 28, 7000));
        String[] names = employeeList.getEmployeeNames();
        assertArrayEquals(new String[]{"Alice", "Bob", "Charlie", "David"}, names);
    }
}