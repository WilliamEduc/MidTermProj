package CodeBase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);




        /**
         *
         * Complete the code
         */
    displayPayroll();
    printPayslip();



    }

    public static void displayPayroll() {

        Scanner scanner = new Scanner(System.in);
        /**
         *
         * Complete the code
         */


        CodeBase.Payroll employeeDetails = new CodeBase.Payroll();

        System.out.println("Welcome to ABC Payroll System");


        do {
            try {
                System.out.println("Enter Employee ID (Format : EMP-XXXX: ");
                String employeeIdInput  = scanner.nextLine();
                employeeDetails.setEmployeeId(employeeIdInput );

                System.out.println("Enter Full Name: ");
                String employeeNameInput = scanner.nextLine();
                employeeDetails.setEmployeeName(employeeNameInput);

                System.out.println("Enter Department: ");
                String departmentInput = scanner.nextLine();
                employeeDetails.setDepartment(departmentInput);

                System.out.println("Enter Basic Monthly Salary PHPsymbol: ");
                double basicSalaryInput = Double.parseDouble(scanner.nextLine());
                employeeDetails.setBasicSalary(basicSalaryInput);

                System.out.println("Enter Overtime Hours Worked: ");
                double overTimeHoursInput = Double.parseDouble(scanner.nextLine());
                employeeDetails.setOvertimeHours(overTimeHoursInput);





            }catch (Exception e){
                System.out.println("An Error occurred: Invalid Employee Id format.");
            }



        }while(true);

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

