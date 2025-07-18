package CodeBase;

/*
 * Handles all salary-related computations
 */
public class SalaryCalculations {

    private Payroll payroll;

    public SalaryCalculations(Payroll payroll) {
        this.payroll = payroll; // connect to the existing Payroll object
    }

    // 1. Get standard hourly rate from basic salary
    public double getHourlyRate() {
        return payroll.getBasicSalary() / 160.0; // 160 hours/month
    }

    // 2. Compute overtime pay (OT rate = hourly * 1.25)
    public double calculateOvertimePay() {
        double overtimeRate = getHourlyRate() * 1.25;
        return overtimeRate * payroll.getOvertimeHours();
    }

    // 3. Compute gross pay (basic salary + overtime pay)
    public double calculateGrossPay() {
        return payroll.getBasicSalary() + calculateOvertimePay();
    }

    // 4. Compute and store everything back into Payroll
    public void calculateAndStorePayroll() {
        // Calculate values
        double hourlyRate = getHourlyRate();
        double overtimeRate = hourlyRate * 1.25;
        double overtimePay = calculateOvertimePay();
        double grossPay = calculateGrossPay();

        // Set values in Payroll object
        payroll.setHourlyRate(hourlyRate);
        payroll.setOvertimeRate(overtimeRate);
        payroll.setOvertimePay(overtimePay);
        payroll.setGrossPay(grossPay);

        // Call deductions class
        StatutoryDeductions deductions = new StatutoryDeductions();

        payroll.setSssContribution(deductions.calculateSSSContribution(payroll.getBasicSalary()));

        payroll.setPhilHealthContribution(deductions.calculatePhilHealthContribution(payroll.getBasicSalary()));

        payroll.setPagIbigContribution(deductions.calculatePagIbigContribution());

        // fixed
        payroll.setIncomeTax(deductions.calculateMonthlyTaxFromYearly(grossPay));

        // Calculate total deductions
        double totalDeductions = payroll.getSssContribution() +
                payroll.getPhilHealthContribution() +
                payroll.getPagIbigContribution() +
                payroll.getIncomeTax();

        payroll.setTotalDeductions(totalDeductions);

        // Compute net pay
        double netPay = payroll.getGrossPay() - totalDeductions;
        payroll.setNetPay(netPay);
    }
}
