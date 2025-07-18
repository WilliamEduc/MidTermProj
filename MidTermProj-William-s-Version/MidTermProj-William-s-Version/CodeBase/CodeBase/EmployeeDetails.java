package CodeBase;

import java.util.Scanner;


public class EmployeeDetails {
    private Payroll payroll;

    public EmployeeDetails() {
        this.payroll = new Payroll();
    }

    public void inputEmployeeDetails() {
        Scanner scanner = new Scanner(System.in);
        Checker check = new Checker();

        String id;
        while (true) {
            System.out.print("Enter Employee ID: ");
            id = scanner.nextLine();
            if (check.isValidEmployeeId(id)) {
                payroll.setEmployeeId(id);
                break;
            } else {
                System.out.println(check.getEmployeeIdErrorMessage(id));
            }
        }

        String name;
        while (true) {
            System.out.print("Enter Employee Name: ");
            name = scanner.nextLine();
            if (check.isValidEmployeeName(name)) {
                payroll.setEmployeeName(name);
                break;
            } else {
                System.out.println(check.getEmployeeNameErrorMessage(name));
            }
        }

                String dept;
        while (true) {
            System.out.print("Enter Department: ");
            dept = scanner.nextLine();
            if (!dept.trim().isEmpty()) {
                payroll.setDepartment(dept);
                break;
            } else {
                System.out.println("Department cannot be empty. Please try again!");
            }
        }


        double salary;
        while (true) {
            System.out.print("Enter Basic Salary: ");
            try {
                salary = scanner.nextDouble();
                if (check.isValidBasicSalary(salary)) {
                    payroll.setBasicSalary(salary);
                    break;
                } else {
                    System.out.println(check.getBasicSalaryErrorMessage(salary));
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }

        int hours;
        while (true) {
            System.out.print("Enter Overtime Hours: ");
            try {
                hours = scanner.nextInt();
                if (check.isValidOvertimeHours(hours)) {
                    payroll.setOvertimeHours(hours);
                    break;
                } else {
                    System.out.println(check.getOvertimeHoursErrorMessage(hours));
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }


    public Payroll getPayroll() {
        return payroll;
    }
}
