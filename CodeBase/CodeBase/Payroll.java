package CodeBase;

import java.util.Scanner;

public class Payroll {
    private String employeeId;
    private String employeeName;
    private String department;
    private double basicSalary;
    private double overtimeHours;
    private double hourlyRate;
    private double overtimeRate;
    private double overtimePay;
    private double grossPay;
    private double sssContribution;
    private double philHealthContribution;
    private double pagIbigContribution;
    private double incomeTax;
    private double totalDeductions;
    private double netPay;


    //default constructor
    // Initializes all fields to default values
    public Payroll() {
        this.employeeId = "";
        this.employeeName = "";
        this.department = "";
        this.basicSalary = 0.0;
        this.overtimeHours = 0.0;
        this.hourlyRate = 0.0;
        this.overtimeRate = 0.0;
        this.overtimePay = 0.0;
        this.grossPay = 0.0;
        this.sssContribution = 0.0;
        this.philHealthContribution = 0.0;
        this.pagIbigContribution = 0.0;
        this.incomeTax = 0.0;
        this.totalDeductions = 0.0;
        this.netPay = 0.0;
    }


    //setters and getters

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setOvertimeRate(double overtimeRate) {
        this.overtimeRate = overtimeRate;
    }

    public void setOvertimePay(double overtimePay) {
        this.overtimePay = overtimePay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public void setSssContribution(double sssContribution) {
        this.sssContribution = sssContribution;
    }

    public void setPhilHealthContribution(double philHealthContribution) {
        this.philHealthContribution = philHealthContribution;
    }

    public void setPagIbigContribution(double pagIbigContribution) {
        this.pagIbigContribution = pagIbigContribution;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public void setTotalDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }


    //getters

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }

    public double getOvertimePay() {
        return overtimePay;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public double getSssContribution() {
        return sssContribution;
    }

    public double getPhilHealthContribution() {
        return philHealthContribution;
    }

    public double getPagIbigContribution() {
        return pagIbigContribution;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public double getTotalDeductions() {
        return totalDeductions;
    }

    public double getNetPay() {
        return netPay;
    }


    public void InputEmployeeDetails() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Welcome to ABC Payroll System");

            System.out.print("Enter Employee ID (Format: EMP-XXXX): ");
            this.setEmployeeId(scanner.nextLine());

            System.out.print("Enter Full Name: ");
            this.setEmployeeName(scanner.nextLine());

            System.out.print("Enter Department: ");
            this.setDepartment(scanner.nextLine());

            System.out.print("Enter Basic Monthly Salary PHPsymbol: ");
            this.setBasicSalary(Double.parseDouble(scanner.nextLine()));

            System.out.print("Enter Overtime Hours Worked: ");
            this.setOvertimeHours(Double.parseDouble(scanner.nextLine()));


        } catch (Exception e) {
            System.out.println("An error occurred: Invalid input.");
        }
    }

//    private void calculatePayroll() {
//        double hourlyRate = this.getBasicSalary() / 160;
//        this.setHourlyRate(hourlyRate);
//
//        double overtimeRate = this.getHourlyRate() * 1.25;
//        this.setOvertimeRate(overtimeRate);
//
//
//        double overtimePay = this.getOvertimeHours() * this.getOvertimeRate();
//        this.setOvertimePay(overtimePay);
//
//
//        double grossPay = this.getBasicSalary() + overtimePay;
//        this.setGrossPay(grossPay);
//
//
//        this.calculateSSS();
//        this.calculatePhilHealth();
//        this.calculatePagIbig();
//
//
//        this.calculateIncomeTax();
//
//
//        double totalDeductions = this.getSssContribution() +
//                this.getPhilHealthContribution() +
//                this.getPagIbigContribution() +
//                this.getIncomeTax();
//        this.setTotalDeductions(totalDeductions);
//
//
//        double netPay = this.getGrossPay() - totalDeductions;
//        this.setNetPay(netPay);
//    }
//
//    private void calculateSSS() {
//
//        double sssContribution = this.getBasicSalary() * 0.045;
//        this.setSssContribution(Math.min(sssContribution, 1350));
//    }
//
//    private void calculatePhilHealth() {
//
//        double philHealthContribution = this.getBasicSalary() * 0.025;
//        this.setPhilHealthContribution(Math.min(philHealthContribution, 3750));
//    }
//
//    private void calculatePagIbig() {
//
//        double pagIbigContribution = this.getBasicSalary() * 0.02;
//        this.setPagIbigContribution(Math.min(pagIbigContribution, 100));
//    }
//
//    private void calculateIncomeTax() {
//
//        double taxableIncome = this.getGrossPay();
//        double tax = 0;
//
//        if (taxableIncome <= 20833) {
//            tax = 0;
//        } else if (taxableIncome <= 33333) {
//            tax = (taxableIncome - 20833) * 0.20;
//        } else if (taxableIncome <= 66667) {
//            tax = 2500 + (taxableIncome - 33333) * 0.25;
//        } else if (taxableIncome <= 166667) {
//            tax = 10833 + (taxableIncome - 66667) * 0.30;
//        } else if (taxableIncome <= 666667) {
//            tax = 40833.33 + (taxableIncome - 166667) * 0.32;
//        } else {
//            tax = 200833.33 + (taxableIncome - 666667) * 0.35;
//        }
//
//        this.setIncomeTax(tax);

        public void printPayslip() {
            System.out.println("\nABC Solutions - Employee Payslip (2025)");
            System.out.println("=================================");
            System.out.println("Employee ID: " + this.getEmployeeId());
            System.out.println("Name: " + this.getEmployeeName());
            System.out.println("Department: " + this.getDepartment());

            System.out.println("\nEARNINGS");
            System.out.printf("Basic Salary: PHP %.2f\n", this.getBasicSalary());
            System.out.printf("Hourly Rate: PHP %.2f\n", this.getHourlyRate());
            System.out.printf("Overtime Rate: PHP %.2f\n", this.getOvertimeRate());
            System.out.printf("Overtime Pay: PHP %.2f\n", this.getOvertimePay());
            System.out.printf("Gross Pay: PHP %.2f\n", this.getGrossPay());

            System.out.println("\nDEDUCTIONS");
            System.out.printf("SSS Contribution: PHP %.2f\n", this.getSssContribution());
            System.out.printf("PhilHealth Contribution: PHP %.2f\n", this.getPhilHealthContribution());
            System.out.printf("Pag-IBIG Contribution: PHP %.2f\n", this.getPagIbigContribution());
            System.out.printf("Income Tax: PHP %.2f\n", this.getIncomeTax());
            System.out.printf("Total Deductions: PHP %.2f\n", this.getTotalDeductions());

            System.out.println("=================================");
            System.out.printf("NET PAY: PHP %.2f\n", this.getNetPay());
            System.out.println("=================================");
        }
    }

