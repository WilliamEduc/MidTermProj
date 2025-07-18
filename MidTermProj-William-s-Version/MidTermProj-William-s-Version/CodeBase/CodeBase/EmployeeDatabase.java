package CodeBase;

import java.util.ArrayList;

public class EmployeeDatabase {
    private final ArrayList<Payroll> employees = new ArrayList<>();

    public void addEmployee(Payroll employee) {
        employees.add(employee);
    }

    public boolean removeEmployeeById(String employeeId) {
        return employees.removeIf(emp -> emp.getEmployeeId().equals(employeeId));
    }

    public ArrayList<Payroll> getAllEmployees() {
        return employees;
    }
} 