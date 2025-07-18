package CodeBase;


public class SalaryCalculations {

    private Payroll payroll;

    public SalaryCalculations(Payroll payroll) {
        this.payroll = payroll;
    }

    public double getHourlyRate() {
        return payroll.getBasicSalary() / 160.0;
    }

    public double calculateOvertimePay() {
        double overtimeRate = getHourlyRate() * 1.25;
        return overtimeRate * payroll.getOvertimeHours();
    }

    public double calculateGrossPay() {
        return payroll.getBasicSalary() + calculateOvertimePay();
    }

    public void calculateAndStorePayroll() {
        double hourlyRate = getHourlyRate();
        double overtimeRate = hourlyRate * 1.25;
        double overtimePay = calculateOvertimePay();
        double grossPay = calculateGrossPay();

        payroll.setHourlyRate(hourlyRate);
        payroll.setOvertimeRate(overtimeRate);
        payroll.setOvertimePay(overtimePay);
        payroll.setGrossPay(grossPay);

        StatutoryDeductions deductions = new StatutoryDeductions();

        payroll.setSssContribution(deductions.calculateSSSContribution(payroll.getBasicSalary()));

        payroll.setPhilHealthContribution(deductions.calculatePhilHealthContribution(payroll.getBasicSalary()));

        payroll.setPagIbigContribution(deductions.calculatePagIbigContribution());

        payroll.setIncomeTax(deductions.calculateMonthlyTaxFromYearly(grossPay));

        double totalDeductions = payroll.getSssContribution() +
                payroll.getPhilHealthContribution() +
                payroll.getPagIbigContribution() +
                payroll.getIncomeTax();

        payroll.setTotalDeductions(totalDeductions);

        double netPay = payroll.getGrossPay() - totalDeductions;
        payroll.setNetPay(netPay);
    }
}
