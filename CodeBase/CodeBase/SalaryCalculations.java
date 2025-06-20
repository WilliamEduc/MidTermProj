package CodeBase;

public class SalaryCalculations {
        private String name;
    private double salary;
    private double otHours;

    public Overtime(){
        name = " ";
        salary = 0.00;
        otHours = 0.00;
    }
    public String getName(){
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public double getOtHours() {
        return otHours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setOtHours(double otHours) {
        this.otHours = otHours;
    }
    public double getHourlyRate(){
        double hourlyRate = salary / 160.0;
        return hourlyRate;
    }
    public double calculateOvertimePay(){
        double otRate = getHourlyRate() * 1.25;
        return otRate * getOtHours();
    }
    public void display(){

        System.out.println("Full name: " + getName());
        System.out.println("Monthly Salary: " + getSalary());
        System.out.println("Overtime Hours Worked: " + getOtHours());
        System.out.println("Overtime Pay: " + calculateOvertimePay());
    }

   //Method to calculate gross pay
   public double calculateGrossPay() {
       return ;
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
