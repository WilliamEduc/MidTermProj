package Project.CodeBase.CodeBase;


import java.util.Scanner;

public class Payroll {
    //decralation of viarables
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

            String regex = "^EMP-\\d{4}$";
            String employeeId;
            while (true) {
                System.out.print("Enter Employee ID (Format: EMP-XXXX): ");
                employeeId = scanner.nextLine();

                if (Pattern.matches(regex, employeeId)) {
                    this.setEmployeeId(employeeId);
                    break;
                }
                System.out.println("Invalid format. Please follow the format: EMP-XXXX");
            }

             while (true) {
                System.out.print("Enter Full Name: ");
                employeeName = scanner.nextLine().trim();
                if (!employeeName.isEmpty() && !employeeName.matches(".*\\d.*")) {
                    this.setEmployeeName(employeeName);
                    break;
                }
                System.out.println("Invalid input. Please try again!");
            }

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            System.out.print("Enter Basic Monthly Salary ₱: ");
            double basicSalary = scanner.nextDouble();
            
            while (basicSalary < 0){
                System.out.print("Negative values, enter again. Enter Basic Monthly Salary PHPsymbol: ");
                basicSalary = scanner.nextDouble();
            }

            System.out.print("Enter Overtime Hours Worked: ");
            int overtimeHours = scanner.nextInt();

            while(overtimeHours < 0){
                System.out.print("Negative values, enter again. Enter Overtime Hours Worked");
                overtimeHours = scanner.nextInt();
            }

            this.setEmployeeId(employeeId);
            this.setEmployeeName(employeeName);
            this.setDepartment(department);
            this.setBasicSalary(basicSalary);
            this.setOvertimeHours(overtimeHours);

            calculatePayrollValues(basicSalary, overtimeHours);

            printPayslip();

        } catch (Exception e) {
            System.out.println("An error occurred: Invalid input.");
        }
    }

    private void calculatePayrollValues(double basicSalary, double overtimeHours) {
        SalaryCalculations salaryCalc = new SalaryCalculations();
        salaryCalc.setSalary(basicSalary);
        salaryCalc.setOtHours(overtimeHours);

        // Calculate earnings
        this.setHourlyRate(salaryCalc.getHourlyRate());
        this.setOvertimeRate(this.getHourlyRate() * 1.25);
        this.setOvertimePay(salaryCalc.calculateOvertimePay());
        this.setGrossPay(salaryCalc.calculateGrossPay());

        // Create StatutoryDeductions object
        StatutoryDeductions deductions = new StatutoryDeductions();

        // Calculate and set deductions
        this.setSssContribution(deductions.calculateSSSContribution(basicSalary));
        this.setPhilHealthContribution(deductions.calculatePhilHealthContribution(basicSalary));
        this.setPagIbigContribution(deductions.calculatePagIbigContribution());
        this.setIncomeTax(deductions.calculateMonthlyTaxFromYearly(basicSalary));

        // Calculate total deductions and net pay
        double totalDeductions = this.getSssContribution() +
                this.getPhilHealthContribution() +
                this.getPagIbigContribution() +
                this.getIncomeTax();

        this.setTotalDeductions(totalDeductions);
        this.setNetPay(this.getGrossPay() - totalDeductions);
    }


    public void printPayslip() {
        System.out.println("\nABC Solutions - Employee Payslip (2025)");
        System.out.println("=================================");
        System.out.println("Employee ID: " + this.getEmployeeId());
        System.out.println("Name: " + this.getEmployeeName());
        System.out.println("Department: " + this.getDepartment());

        System.out.println("\nEARNINGS");
        System.out.printf("Basic Salary: ₱%.2f\n", this.getBasicSalary());
        System.out.printf("Overtime Pay: ₱%.2f\n", this.getOvertimePay());
        System.out.printf("Gross Pay: ₱%.2f\n", this.getGrossPay());

            System.out.println("\nDEDUCTIONS");
            System.out.printf("SSS Contribution: ₱%.2f\n", this.getSssContribution());
            System.out.printf("PhilHealth Contribution: ₱%.2f\n", this.getPhilHealthContribution());
            System.out.printf("Pag-IBIG Contribution: ₱%.2f\n", this.getPagIbigContribution());
            System.out.printf("Income Tax: ₱%.2f\n", this.getIncomeTax());
            System.out.printf("Total Deductions: ₱%.2f\n", this.getTotalDeductions());

            System.out.println("=================================");
            System.out.printf("NET PAY: ₱%.2f\n", this.getNetPay());
            System.out.println("=================================");
        }
    }

/* here na yung final, boss 
package Project.CodeBase;


import java.util.Scanner;
import java.util.regex.Pattern;

public class Payroll {
    //decralation of viarables
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

            String regex = "^EMP-\\d{4}$";
            String employeeId;
            while (true) {
                System.out.print("Enter Employee ID (Format: EMP-XXXX): ");
                employeeId = scanner.nextLine();

                if (Pattern.matches(regex, employeeId)) {
                    this.setEmployeeId(employeeId);
                    break;
                }
                System.out.println("Invalid format. Please follow the format: EMP-XXXX");
            }

            while (true) {
                System.out.print("Enter Full Name: ");
                employeeName = scanner.nextLine().trim();
                if (!employeeName.isEmpty() && !employeeName.matches(".*\\d.*")) {
                    this.setEmployeeName(employeeName);
                    break;
                }
                System.out.println("Invalid input. Please try again!");
            }

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            System.out.print("Enter Basic Monthly Salary ₱: ");
            double basicSalary = scanner.nextDouble();

            while (basicSalary < 0){
                System.out.print("Negative values, enter again. Enter Basic Monthly Salary PHPsymbol: ");
                basicSalary = scanner.nextDouble();
            }

            System.out.print("Enter Overtime Hours Worked: ");
            int overtimeHours = scanner.nextInt();

            while(overtimeHours < 0){
                System.out.print("Negative values, enter again. Enter Overtime Hours Worked");
                overtimeHours = scanner.nextInt();
            }

            this.setEmployeeId(employeeId);
            this.setEmployeeName(employeeName);
            this.setDepartment(department);
            this.setBasicSalary(basicSalary);
            this.setOvertimeHours(overtimeHours);

            calculatePayrollValues(basicSalary, overtimeHours);

            printPayslip();

        } catch (Exception e) {
            System.out.println("An error occurred: Invalid input.");
        }
    }

    private void calculatePayrollValues(double basicSalary, double overtimeHours) {
        SalaryCalculations salaryCalc = new SalaryCalculations();
        salaryCalc.setSalary(basicSalary);
        salaryCalc.setOtHours(overtimeHours);

        // Calculate earnings
        this.setHourlyRate(salaryCalc.getHourlyRate());
        this.setOvertimeRate(this.getHourlyRate() * 1.25);
        this.setOvertimePay(salaryCalc.calculateOvertimePay());
        this.setGrossPay(salaryCalc.calculateGrossPay());

        // Create StatutoryDeductions object
        StatutoryDeductions deductions = new StatutoryDeductions();

        // Calculate and set deductions
        this.setSssContribution(deductions.calculateSSSContribution(basicSalary));
        this.setPhilHealthContribution(deductions.calculatePhilHealthContribution(basicSalary));
        this.setPagIbigContribution(deductions.calculatePagIbigContribution());
        
        this.setIncomeTax(deductions.calculateMonthlyTaxFromYearly(basicSalary));

        // Calculate total deductions and net pay
        double totalDeductions = this.getSssContribution() +
                this.getPhilHealthContribution() +
                this.getPagIbigContribution() +
                this.getIncomeTax();

        this.setTotalDeductions(totalDeductions);
        this.setNetPay(this.getGrossPay() - totalDeductions);
    }


    public void printPayslip() {
        System.out.println("\nABC Solutions - Employee Payslip (2025)");
        System.out.println("=================================");
        System.out.println("Employee ID: " + this.getEmployeeId());
        System.out.println("Name: " + this.getEmployeeName());
        System.out.println("Department: " + this.getDepartment());

        System.out.println("\nEARNINGS");
        System.out.printf("Basic Salary: ₱ %.2f\n", this.getBasicSalary());
        System.out.printf("Overtime Pay: ₱ %.2f\n", this.getOvertimePay());
        System.out.printf("Gross Pay: ₱ %.2f\n", this.getGrossPay());

        System.out.println("\nDEDUCTIONS  (2025 rates)");
        System.out.printf("SSS Contribution: ₱ %.2f\n", this.getSssContribution());
        System.out.printf("PhilHealth Contribution: ₱ %.2f\n", this.getPhilHealthContribution());
        System.out.printf("Pag-IBIG Contribution: ₱ %.2f\n", this.getPagIbigContribution());
        System.out.printf("Income Tax: ₱ %.2f\n", this.getIncomeTax());
        System.out.printf("Total Deductions: ₱ %.2f\n", this.getTotalDeductions());

        System.out.println("=================================");
        System.out.printf("NET PAY: ₱ %.2f\n", this.getNetPay());
        System.out.println("=================================");
    }
}
*/
