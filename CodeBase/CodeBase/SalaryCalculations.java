package CodeBase;

public class SalaryCalculations extends CodeBase.Payroll {
    private String name;
    private double monthlySalary;
    private double hoursWorked;

      public Employee(String name, double monthlySalary, double hoursWorked){
        this.name = name;
        this.monthlySalary= monthlySalary;
        this.hoursWorked = hoursWorked;
    }
      public void setName(String name) {
        this.name = name;
    }
  
    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public String getName(){
        return name;
    }
  
    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyRate(){
        return monthlySalary / 160;
    }
  
   // Method to calculate overtime pay
   public double calculateOvertimePay() {
             if (hoursWorked > 160){
            overtimeHours = hoursWorked - 160;
        }
        return overtimeHours * getHourlyRate() * 1.25;
    }
  
      public void display(){
        System.out.println("Full name: " + name);
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Overtime Hours Worked: " + hoursWorked);
        System.out.println("Overtime Pay: " + calculateOvertimePay());
    }
  
   //Method to calculate gross pay
   public double calculateGrossPay() {
       return;
   }

   //Method to calculate total deductions
   public double totalDeductions() {
       return ;
   }

   //Method to calculate total net pay
   public double calculateNetPay() {
       return ;
   }
}
