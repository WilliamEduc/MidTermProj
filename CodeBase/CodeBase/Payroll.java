package CodeBase;

import CodeBase.SalaryCalculations;

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


}
