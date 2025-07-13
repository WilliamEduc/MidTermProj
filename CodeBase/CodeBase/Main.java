package CodeBase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDatabase db = new EmployeeDatabase();

        while (true) {
            // Display menu
            System.out.println("\nABC Payroll System");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. List Employees");
            System.out.println("4. Generate Payroll for Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            if (option.equals("1")) {
                addEmployee(db);
            } else if (option.equals("2")) {
                removeEmployee(db, scanner);
            } else if (option.equals("3")) {
                listEmployees(db);
            } else if (option.equals("4")) {
                generatePayroll(db, scanner);
            } else if (option.equals("5")) {
                System.out.println("Exiting program. All employee data will be lost.");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Option 1: Add Employee
    private static void addEmployee(EmployeeDatabase db) {
        EmployeeDetails details = new EmployeeDetails();
        details.inputEmployeeDetails();
        db.addEmployee(details.getPayroll());
        System.out.println("Employee added successfully.");
    }

    // Option 2: Remove Employee
    private static void removeEmployee(EmployeeDatabase db, Scanner scanner) {
        System.out.print("Enter Employee ID to remove: ");
        String id = scanner.nextLine();
        if (db.removeEmployeeById(id)) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Option 3: List Employees
    private static void listEmployees(EmployeeDatabase db) {
        if (db.getAllEmployees().isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("\nEmployee List:");
            for (Payroll emp : db.getAllEmployees()) {
                System.out.println("ID: " + emp.getEmployeeId() + ", Name: " + emp.getEmployeeName() + ", Department: " + emp.getDepartment() + ", Salary: " + emp.getBasicSalary() + ", Overtime: " + emp.getOvertimeHours());
            }
        }
    }

    // Option 4: Generate Payroll
    private static void generatePayroll(EmployeeDatabase db, Scanner scanner) {
        System.out.print("Enter Employee ID to generate payroll: ");
        String id = scanner.nextLine();
        Payroll emp = null;
        for (Payroll e : db.getAllEmployees()) {
            if (e.getEmployeeId().equals(id)) {
                emp = e;
                break;
            }
        }
        if (emp != null) {
            SalaryCalculations calc = new SalaryCalculations(emp);
            calc.calculateAndStorePayroll();
            Print printer = new Print(emp);
            printer.printPayslip();
        } else {
            System.out.println("Employee not found.");
        }
    }
}
