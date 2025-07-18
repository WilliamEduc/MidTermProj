package CodeBase;
import java.util.regex.Pattern;

/*
This class validates the employee ID, name, salary, and overtime hours.
If the input is invalid, it will provide a appropriate error messages.
*/
public class Checker {
    
    /*
    Regex pattern for validating employee ID format.
    */
    private static final String EMPLOYEE_ID_REGEX = "^EMP-\\d{4}$";
    
    public boolean isValidEmployeeId(String employeeId) {
        return employeeId != null && Pattern.matches(EMPLOYEE_ID_REGEX, employeeId.trim());
    }
    
    /*
    Validates the employee name.
    Name should not be empty or contain any digits.
    */
    public boolean isValidEmployeeName(String employeeName) {
        return employeeName != null && !employeeName.trim().isEmpty() && !employeeName.trim().matches(".*\\d.*");
    }
    

    // Validates that the basic salary is non-negative.
    public boolean isValidBasicSalary(double basicSalary) {
        return basicSalary >= 0;
    }
    

     // Validates that the number of overtime hours is non-negative.
    public boolean isValidOvertimeHours(int overtimeHours) {
        return overtimeHours >= 0;
    }
    
    /*
    This class provides an error message if the employee ID is invalid.
    */
    public String getEmployeeIdErrorMessage(String employeeId) {
        if (!isValidEmployeeId(employeeId)) {
            return "Invalid format. Please follow the format: EMP-XXXX";
        }
        return null;
    }
    
    /*
    This class provides an error message if the employee name is invalid.
    */
    public String getEmployeeNameErrorMessage(String employeeName) {
        if (!isValidEmployeeName(employeeName)) {
            return "Invalid input. Please try again!";
        }
        return null;
    }
    
     /*
    This class provides an error message if the basic salary is invalid.
    */
    public String getBasicSalaryErrorMessage(double basicSalary) {
        if (!isValidBasicSalary(basicSalary)) {
            return "Negative values, enter again. Enter Basic Monthly Salary PHPsymbol: ";
        }
        return null;
    }
    
        /*
    This class provides an error message if the overtime hours is invalid.
    */
    public String getOvertimeHoursErrorMessage(int overtimeHours) {
        if (!isValidOvertimeHours(overtimeHours)) {
            return "Negative values, enter again. Enter Overtime Hours Worked";
        }
        return null;
    }
}
