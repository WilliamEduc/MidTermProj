package CodeBase;

import java.util.Scanner;

//this class is for getting the employee details only

public class EmployeeDetails {
    private Payroll payroll;

    public EmployeeDetails() {
        this.payroll = new Payroll();  // create Payroll object to store data
    }

    public void inputEmployeeDetails() {
        Scanner scanner = new Scanner(System.in);
        Checker check = new Checker();

        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        if (check.isValidEmployeeId(id)) {
            payroll.setEmployeeId(id);
        } else {
            System.out.println(check.getEmployeeIdErrorMessage(id));
        }

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        if (check.isValidEmployeeName(name)) {
            payroll.setEmployeeName(name);
        } else {
            System.out.println(check.getEmployeeNameErrorMessage(name));
        }

        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();
            payroll.setDepartment(dept);


        System.out.print("Enter Basic Salary: ");
        double salary = scanner.nextDouble();
        if (check.isValidBasicSalary(salary)) {
            payroll.setBasicSalary(salary);
        } else {
            System.out.println(check.getBasicSalaryErrorMessage(salary));
        }

        System.out.print("Enter Overtime Hours: ");
        int hours = scanner.nextInt();
        if (check.isValidOvertimeHours(hours)) {
            payroll.setOvertimeHours(hours);
        } else {
            System.out.println(check.getOvertimeHoursErrorMessage(hours));
        }
    }

    //allows other classes to access the payroll object that’s
    // stored inside the EmployeeDetails class.
    public Payroll getPayroll() {
        return payroll;
    }
}

