package CodeBase;

public class Print {

    private Payroll payroll;

    public Print(Payroll payroll) {
        this.payroll = payroll;
    }

    public void printPayslip() {
        System.out.println("\nABC Solutions - Employee Payslip (2025)");
        System.out.println("=========================================");
        System.out.println("Employee ID: " + payroll.getEmployeeId());
        System.out.println("Name: " + payroll.getEmployeeName());
        System.out.println("Department: " + payroll.getDepartment());

        System.out.println("\nEARNINGS");
        System.out.printf("Basic Salary: ₱ %.2f\n", payroll.getBasicSalary());
        System.out.printf("Overtime Pay: ₱ %.2f\n", payroll.getOvertimePay());
        System.out.printf("Gross Pay: ₱ %.2f\n", payroll.getGrossPay());

        System.out.println("\nDEDUCTIONS  (2025 rates)");
        System.out.printf("SSS Contribution: ₱ %.2f\n", payroll.getSssContribution());
        System.out.printf("PhilHealth Contribution: ₱ %.2f\n", payroll.getPhilHealthContribution());
        System.out.printf("Pag-IBIG Contribution: ₱ %.2f\n", payroll.getPagIbigContribution());
        System.out.printf("Income Tax: ₱ %.2f\n", payroll.getIncomeTax());
        System.out.printf("Total Deductions: ₱ %.2f\n", payroll.getTotalDeductions());

        System.out.println("=========================================");
        System.out.printf("NET PAY: ₱ %.2f\n", payroll.getNetPay());
        System.out.println("=========================================");
    }
}
