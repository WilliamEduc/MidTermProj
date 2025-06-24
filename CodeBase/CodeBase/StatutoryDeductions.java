    package Project.CodeBase.CodeBase;

   
public class StatutoryDeductions {

    // This is the fixed amount that a person needs to pay for Pag-IBIG each month.
    private static final double PAG_IBIG_RATE = 200;

    /* 
    This method calculates how much a person should pay to the Social Security System (SSS)
    every month based on how much money they earn. 
    If they earn more, they pay more. If the number is less than 0, it says it's not valid.
    */
    public double calculateSSSContribution(double income) {
        if (income >= 0 && income < 5250) {
            return 500;
        } else if (income >= 5250 && income < 5750) {
            return 550;
        } else if (income >= 5750 && income < 6250) {
            return 600;
        } else if (income >= 6250 && income < 6750) {
            return 650;
        } else if (income >= 6750 && income < 7250) {
            return 700;
        } else if (income >= 7250 && income < 7750) {
            return 750;
        } else if (income >= 7750 && income < 8250) {
            return 800;
        } else if (income >= 8250 && income < 8750) {
            return 850;
        } else if (income >= 8750 && income < 9250) {
            return 900;
        } else if (income >= 9250 && income < 9750) {
            return 950;
        } else if (income >= 9750 && income < 10250) {
            return 1000;
        } else if (income >= 10250 && income < 10750) {
            return 1050;
        } else if (income >= 10750 && income < 11250) {
            return 1100;
        } else if (income >= 11250 && income < 11750) {
            return 1150;
        } else if (income >= 11750 && income < 12250) {
            return 1200;
        } else if (income >= 12250 && income < 12750) {
            return 1250;
        } else if (income >= 12750 && income < 13250) {
            return 1300;
        } else if (income >= 13250 && income < 13750) {
            return 1350;
        } else if (income >= 13750 && income < 14250) {
            return 1400;
        } else if (income >= 14250 && income < 14750) {
            return 1450;
        } else if (income >= 14750 && income < 15250) {
            return 1500;
        } else if (income >= 15250 && income < 15750) {
            return 1550;
        } else if (income >= 15750 && income < 16250) {
            return 1600;
        } else if (income >= 16250 && income < 16750) {
            return 1650;
        } else if (income >= 16750 && income < 17250) {
            return 1700;
        } else if (income >= 17250 && income < 17750) {
            return 1750;
        } else if (income >= 17750 && income < 18250) {
            return 1800;
        } else if (income >= 18250 && income < 18750) {
            return 1850;
        } else if (income >= 18750 && income < 19250) {
            return 1900;
        } else if (income >= 19250 && income < 19750) {
            return 1950;
        } else if (income >= 19750 && income < 20250) {
            return 2000;
        } else if (income >= 20250 && income < 20750) {
            return 2050;
        } else if (income >= 20750 && income < 21250) {
            return 2100;
        } else if (income >= 21250 && income < 21750) {
            return 2150;
        } else if (income >= 21750 && income < 22250) {
            return 2200;
        } else if (income >= 22250 && income < 22750) {
            return 2250;
        } else if (income >= 22750 && income < 23250) {
            return 2300;
        } else if (income >= 23250 && income < 23750) {
            return 2350;
        } else if (income >= 23750 && income < 24250) {
            return 2400;
        } else if (income >= 24250 && income < 24750) {
            return 2450;
        } else if (income >= 24750 && income < 25250) {
            return 2500;
        } else if (income >= 25250 && income < 25750) {
            return 2550;
        } else if (income >= 25750 && income < 26250) {
            return 2600;
        } else if (income >= 26250 && income < 26750) {
            return 2650;
        } else if (income >= 26750 && income < 27250) {
            return 2700;
        } else if (income >= 27250 && income < 27750) {
            return 2750;
        } else if (income >= 27750 && income < 28250) {
            return 2800;
        } else if (income >= 28250 && income < 28750) {
            return 2850;
        } else if (income >= 28750 && income < 29250) {
            return 2900;
        } else if (income >= 29250 && income < 29750) {
            return 2950;
        } else if (income >= 29750) {
            return 3000;
        } else {
            // If the income is less than 0, show a message and return 0.
            System.out.println("Invalid income input.");
            return 0;
        }
    }

    /* 
    This method calculates how much a person needs to pay for PhilHealth 
    (health insurance) based on their salary.

    - If the salary is 10,000 pesos or less, they pay 250 pesos.
    - If the salary is 100,000 pesos or more, they pay 2,500 pesos.
    - If it’s between 10,000 and 100,000 pesos, it will compute a value in between.
    */
    public double calculatePhilHealthContribution(double basicSalary) {
        if (basicSalary <= 10000) {
            return 250;
        } else if (basicSalary >= 100000) {
            return 2500;
        } else if (basicSalary >= 50000) {
            return 1250;
        } else {
            return 250 + ((basicSalary - 10000) / 40000) * 1000;
        }
    }

    /* 
    This method gives the fixed amount of money that a person needs to pay 
    for Pag-IBIG every month. It always returns 200 pesos.
    */
    public double calculatePagIbigContribution() {
        return PAG_IBIG_RATE;
    }

    /* 
    This method calculates how much tax a person pays each month 
    based on how much they earn.

    - If they earn 20,833 pesos or less, they don’t pay tax.
    - If they earn more, the tax goes higher depending on the salary.
    */
    public double calculateIncomeTax(double monthlySalary) {
        if (monthlySalary <= 20833) {
            return 0;
        } else if (monthlySalary <= 33333) {
            return (monthlySalary - 20833) * 0.15;
        } else if (monthlySalary <= 66666) {
            return 1875 + (monthlySalary - 33333) * 0.20;
        } else {
            return 8542 + (monthlySalary - 66666) * 0.25;
        }
    }

    /* 
    This method calculates how much tax a person pays in a year.
    It uses bigger numbers and checks which range their yearly income falls under.
    The more they earn, the more tax they pay.
    */
    public double calculateYearlyIncomeTax(double yearlyIncome) {
        if (yearlyIncome <= 250000) return 0;
        if (yearlyIncome <= 400000) return (yearlyIncome - 250000) * 0.15;
        if (yearlyIncome <= 800000) return 22500 + (yearlyIncome - 400000) * 0.20;
        if (yearlyIncome <= 2000000) return 102500 + (yearlyIncome - 800000) * 0.25;
        return 402500 + (yearlyIncome - 2000000) * 0.30;
    }

    /* 
    This method figures out how much monthly tax a person should pay 
    by first calculating their yearly income, then finding the yearly tax,
    and finally dividing it by 12 to get the monthly amount.
    */
    public double calculateMonthlyTaxFromYearly(double monthlySalary) {
        double yearlyIncome = monthlySalary * 12;
        return calculateYearlyIncomeTax(yearlyIncome) / 12;
    }
}



