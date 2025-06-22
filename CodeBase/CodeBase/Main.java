package CodeBase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Payroll employee = new Payroll();                                               //tols, gumagana mga edits ko sa GIT ko
        SalaryCalculations calculations = new SalaryCalculations();

        employee.InputEmployeeDetails();
    }
}



