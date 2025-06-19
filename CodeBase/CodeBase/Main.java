package CodeBase;

import java.util.Scanner;
import CodeBase.Payroll;


public class Main {
    public static void main(String[] args) {


        Payroll employee = new Payroll();
        employee.InputEmployeeDetails(); // read user input
        employee.printPayslip();

    }
}

