package PayrollSystemGUI;

import CodeBase.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;

public class PayrollSystemGUI extends JFrame {
    private EmployeeDatabase db = new EmployeeDatabase();
    private JTextArea displayArea;

    public PayrollSystemGUI() {
        setTitle("ABC Payroll System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Employee");
        JButton removeButton = new JButton("Remove Employee");
        JButton listButton = new JButton("List Employees");
        JButton payrollButton = new JButton("Generate Payroll");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(listButton);
        buttonPanel.add(payrollButton);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addEmployee());
        removeButton.addActionListener(e -> removeEmployee());
        listButton.addActionListener(e -> listEmployees());
        payrollButton.addActionListener(e -> generatePayroll());
    }

    private void addEmployee() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField deptField = new JTextField();
        JTextField salaryField = new JTextField();
        JTextField hoursField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Employee ID (EMP-XXXX):"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Department:"));
        panel.add(deptField);
        panel.add(new JLabel("Basic Salary:"));
        panel.add(salaryField);
        panel.add(new JLabel("Overtime Hours:"));
        panel.add(hoursField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Add Employee", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Checker check = new Checker();
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String dept = deptField.getText().trim();
            String salaryStr = salaryField.getText().trim();
            String hoursStr = hoursField.getText().trim();
            StringBuilder errors = new StringBuilder();
            if (!check.isValidEmployeeId(id)) errors.append(check.getEmployeeIdErrorMessage(id)).append("\n");
            if (!check.isValidEmployeeName(name)) errors.append(check.getEmployeeNameErrorMessage(name)).append("\n");
            if (dept.isEmpty()) errors.append("Department cannot be empty.\n");
            double salary = 0;
            int hours = 0;
            try {
                salary = Double.parseDouble(salaryStr);
                if (!check.isValidBasicSalary(salary)) errors.append(check.getBasicSalaryErrorMessage(salary)).append("\n");
            } catch (Exception ex) {
                errors.append("Invalid salary.\n");
            }
            try {
                hours = Integer.parseInt(hoursStr);
                if (!check.isValidOvertimeHours(hours)) errors.append(check.getOvertimeHoursErrorMessage(hours)).append("\n");
            } catch (Exception ex) {
                errors.append("Invalid overtime hours.\n");
            }
            if (errors.length() > 0) {
                JOptionPane.showMessageDialog(this, errors.toString(), "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Payroll emp = new Payroll();
            emp.setEmployeeId(id);
            emp.setEmployeeName(name);
            emp.setDepartment(dept);
            emp.setBasicSalary(salary);
            emp.setOvertimeHours(hours);
            db.addEmployee(emp);
            displayArea.append("Employee added: " + id + "\n");
        }
    }

    private void removeEmployee() {
        String id = JOptionPane.showInputDialog(this, "Enter Employee ID to remove:");
        if (id != null) {
            if (db.removeEmployeeById(id.trim())) {
                displayArea.append("Employee removed: " + id + "\n");
            } else {
                displayArea.append("Employee not found: " + id + "\n");
            }
        }
    }

    private void listEmployees() {
        displayArea.append("\nEmployee List:\n");
        if (db.getAllEmployees().isEmpty()) {
            displayArea.append("No employees to display.\n");
        } else {
            for (Payroll emp : db.getAllEmployees()) {
                displayArea.append("ID: " + emp.getEmployeeId() + ", Name: " + emp.getEmployeeName() + ", Department: " + emp.getDepartment() + ", Salary: " + emp.getBasicSalary() + ", Overtime: " + emp.getOvertimeHours() + "\n");
            }
        }
    }

    private void generatePayroll() {
        String id = JOptionPane.showInputDialog(this, "Enter Employee ID to generate payroll:");
        if (id == null) return;
        Payroll emp = null;
        for (Payroll e : db.getAllEmployees()) {
            if (e.getEmployeeId().equals(id.trim())) {
                emp = e;
                break;
            }
        }
        if (emp == null) {
            displayArea.append("Employee not found: " + id + "\n");
            return;
        }
        SalaryCalculations calc = new SalaryCalculations(emp);
        calc.calculateAndStorePayroll();
        String payslip = "\nABC Solutions - Employee Payslip (2025)\n" +
                "=================================\n" +
                "Employee ID: " + emp.getEmployeeId() + "\n" +
                "Name: " + emp.getEmployeeName() + "\n" +
                "Department: " + emp.getDepartment() + "\n" +
                "\nEARNINGS\n" +
                String.format("Basic Salary: ₱ %.2f\n", emp.getBasicSalary()) +
                String.format("Overtime Pay: ₱ %.2f\n", emp.getOvertimePay()) +
                String.format("Gross Pay: ₱ %.2f\n", emp.getGrossPay()) +
                "\nDEDUCTIONS  (2025 rates)\n" +
                String.format("SSS Contribution: ₱ %.2f\n", emp.getSssContribution()) +
                String.format("PhilHealth Contribution: ₱ %.2f\n", emp.getPhilHealthContribution()) +
                String.format("Pag-IBIG Contribution: ₱ %.2f\n", emp.getPagIbigContribution()) +
                String.format("Income Tax: ₱ %.2f\n", emp.getIncomeTax()) +
                String.format("Total Deductions: ₱ %.2f\n", emp.getTotalDeductions()) +
                "=================================\n" +
                String.format("NET PAY: ₱ %.2f\n", emp.getNetPay()) +
                "=================================\n";
        int answer = JOptionPane.showConfirmDialog(this, "Do you want to generate a payslip file?", "Generate Payslip", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            String safeName = emp.getEmployeeName().replaceAll("[^a-zA-Z0-9]", "_");
            String filename = safeName + " payslip.txt";
            try (FileWriter writer = new FileWriter(filename)) {
                writer.write(payslip);
                JOptionPane.showMessageDialog(this, "Payslip file generated: " + filename, "Payslip Generated", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error writing payslip file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PayrollSystemGUI().setVisible(true));
    }
} 
