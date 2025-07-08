package CodeBase;

public class Main {
    public static void main(String[] args) {

        // Step 1: Get user input via EmployeeDetails
        EmployeeDetails employee1 = new EmployeeDetails();
        employee1.inputEmployeeDetails();

        // Step 2: Get the Payroll object from EmployeeDetails
        Payroll payroll = employee1.getPayroll();

        // Step 3: Calculate salary details
        SalaryCalculations calc = new SalaryCalculations(payroll);
        calc.calculateAndStorePayroll();

        // Step 4: Print the payslip
        Print printer = new Print(payroll);
        printer.printPayslip();
    }
}
