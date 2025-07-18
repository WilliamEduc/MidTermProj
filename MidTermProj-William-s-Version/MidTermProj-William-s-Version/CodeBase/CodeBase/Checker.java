package CodeBase;
import java.util.regex.Pattern;

public class Checker {
    
    private static final String EMPLOYEE_ID_REGEX = "^EMP-\\d{4}$";
    
   
    public boolean isValidEmployeeId(String employeeId) {
        return employeeId != null && Pattern.matches(EMPLOYEE_ID_REGEX, employeeId.trim());
    }
    
    
    public boolean isValidEmployeeName(String employeeName) {
        return employeeName != null && !employeeName.trim().isEmpty() && !employeeName.trim().matches(".*\\d.*");
    }
    
   
    public boolean isValidBasicSalary(double basicSalary) {
        return basicSalary >= 0;
    }
    
  
    public boolean isValidOvertimeHours(int overtimeHours) {
        return overtimeHours >= 0;
    }
    
    
    public String getEmployeeIdErrorMessage(String employeeId) {
        if (!isValidEmployeeId(employeeId)) {
            return "Invalid format. Please follow the format: EMP-XXXX";
        }
        return null;
    }
    
    
    public String getEmployeeNameErrorMessage(String employeeName) {
        if (!isValidEmployeeName(employeeName)) {
            return "Invalid input. Please try again!";
        }
        return null;
    }
    
    
    public String getBasicSalaryErrorMessage(double basicSalary) {
        if (!isValidBasicSalary(basicSalary)) {
            return "Negative values, enter again. Enter Basic Monthly Salary PHPsymbol: ";
        }
        return null;
    }
    
   
    public String getOvertimeHoursErrorMessage(int overtimeHours) {
        if (!isValidOvertimeHours(overtimeHours)) {
            return "Negative values, enter again. Enter Overtime Hours Worked";
        }
        return null;
    }
}
