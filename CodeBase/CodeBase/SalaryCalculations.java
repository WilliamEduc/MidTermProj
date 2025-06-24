package Project.CodeBase;

/*
 * in this class, it handles all salary-related computations
 * for employees, including regular pay, overtime calculations,
 * and total gross pay computations.
 */
public class SalaryCalculations {
    // Employee name
    private String name;

    // Monthly salary amount
    private double salary;

    // Overtime hours worked
    private double otHours;

    
     // Retrieves the employee's full name.
    
    public String getName() {
        return name;
    }
    
     // Gets the employee's base monthly salary.
    public double getSalary() {
        return salary;
    }

     // Returns the number of overtime hours the employee has worked.
    public double getOtHours() {
        return otHours;
    }

      //Sets the employee's name.
    public void setName(String name) {
        this.name = name;
    }

     // Sets the employee's monthly salary amount.
    public void setSalary(double salary) {
        this.salary = salary;
    }

     // Records the number of overtime hours worked.
    public void setOtHours(double otHours) {
        this.otHours = otHours;
    }

    /*
     * Calculates the standard hourly rate from monthly salary.
     * Assumes 160 working hours per month (40 hours/week × 4 weeks).
     */
    public double getHourlyRate() {
        double hourlyRate = salary / 160.0;
        return hourlyRate;
    }

    /*
     * Calculates overtime pay at premium rate (25% more than normal hourly rate).
     
     * The calculation follows in this steps:
     * 1. First gets the standard hourly rate by dividing monthly salary by 160
     * 2. Then applies 1.25 multiplier for overtime premium pay
     
     * Example: For ₱20,000 monthly salary working 10 OT hours:
     * Hourly rate = 20,000 / 160 = ₱125/hr
     * OT rate = 125 * 1.25 = ₱156.25/hr
     * Total OT pay = 156.25 * 10 = ₱1,562.50
     */
    public double calculateOvertimePay() {
        // Calculate standard hourly rate first
        double otRate = getHourlyRate() * 1.25;

        // Multiply premium rate by OT hours to get total OT pay
        return otRate * getOtHours();
    }

    /*
     * at this point it will display the complete salary breakdown including:
     * Employee name
     * Base salary
     * Overtime hours
     * Overtime pay amount
     * Total gross pay
     */
    public void display() {
        System.out.println("Full name: " + getName());
        System.out.println("Monthly Salary: " + getSalary());
        System.out.println("Overtime Hours Worked: " + getOtHours());
        System.out.println("Overtime Pay: " + calculateOvertimePay());
        System.out.println("Gross Pay: " + calculateGrossPay());
    }

    /*
     * Computes total gross pay by adding:
     *  Base monthly salary
     *  Calculated overtime pay
     */
    public double calculateGrossPay() {
        double grossPay = salary + calculateOvertimePay();
        return grossPay;
    }
}
// pa tell nalang mga pards if may ano na ewan pa 
