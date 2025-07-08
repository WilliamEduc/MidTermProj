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

        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        payroll.setEmployeeId(id);

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        payroll.setEmployeeName(name);

        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();
        payroll.setDepartment(dept);

        System.out.print("Enter Basic Salary: ");
        double salary = scanner.nextDouble();
        payroll.setBasicSalary(salary);

        System.out.print("Enter Overtime Hours: ");
        int hours = scanner.nextInt();
        payroll.setOvertimeHours(hours);
    }

    //allows other classes to access the payroll object that’s
    // stored inside the EmployeeDetails class.
    public Payroll getPayroll() {
        return payroll;
    }
}