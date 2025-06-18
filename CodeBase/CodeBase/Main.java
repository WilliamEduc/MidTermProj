package CodeBase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);




        /**
         *
         * Complete the code
         */
        // Get filled Payroll object from displayPayroll()
        CodeBase.Payroll employee = displayPayroll();

        // Pass the employee object to printPayslip
        printPayslip(employee);


    }

    public static CodeBase.Payroll displayPayroll() {
        Scanner scanner = new Scanner(System.in);
        CodeBase.Payroll employeeDetails = new CodeBase.Payroll();

        System.out.println("Welcome to ABC Payroll System");

        try {
            System.out.print("Enter Employee ID (Format: EMP-XXXX): ");
            String employeeIdInput = scanner.nextLine();
            employeeDetails.setEmployeeId(employeeIdInput);

            System.out.print("Enter Full Name: ");
            String employeeNameInput = scanner.nextLine();
            employeeDetails.setEmployeeName(employeeNameInput);

            System.out.print("Enter Department: ");
            String departmentInput = scanner.nextLine();
            employeeDetails.setDepartment(departmentInput);

            System.out.print("Enter Basic Monthly Salary PHPsymbol: ");
            double basicSalaryInput = Double.parseDouble(scanner.nextLine());
            employeeDetails.setBasicSalary(basicSalaryInput);

            System.out.print("Enter Overtime Hours Worked: ");
            double overTimeHoursInput = Double.parseDouble(scanner.nextLine());
            employeeDetails.setOvertimeHours(overTimeHoursInput);

        } catch (Exception e) {
            System.out.println("An error occurred: Invalid input.");
        }

        return employeeDetails;
    }


    public static void printPayslip(CodeBase.Payroll employeeDetails) {


        System.out.println("\nABC Solutions - Employee Payslip (2025)");
        System.out.println("=================================");

        System.out.println("Employee ID: " + employeeDetails.getEmployeeId());

        System.out.println("Name: " + employeeDetails.getEmployeeName());

        System.out.println("Department: " + employeeDetails.getDepartment());

        System.out.println("=================================");
    }
}

