package PayrollSystemGUI;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.util.Optional;


public class PayrollSystemGUI {
    private EmployeeDatabased db = new EmployeeDatabased();
    private Checker checker = new Checker();


    private JFrame mainFrame;
    private JPanel mainPanel;
    private CardLayout cardLayout;


    private JPanel menuPanel;
    private JPanel addEmployeePanel;
    private JPanel removeEmployeePanel;
    private JPanel listEmployeesPanel;
    private JPanel generatePayrollPanel;


    public PayrollSystemGUI() {
        initializeGUI();
    }


    private void initializeGUI() {
        mainFrame = new JFrame("ABC Payroll System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 450);
        mainFrame.setLocationRelativeTo(null);


        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);


        createMenuPanel();
        createAddEmployeePanel();
        createRemoveEmployeePanel();
        createListEmployeesPanel();
        createGeneratePayrollPanel();


        mainPanel.add(menuPanel, "Menu");
        mainPanel.add(addEmployeePanel, "AddEmployee");
        mainPanel.add(removeEmployeePanel, "RemoveEmployee");
        mainPanel.add(listEmployeesPanel, "ListEmployees");
        mainPanel.add(generatePayrollPanel, "GeneratePayroll");


        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }


    private void createMenuPanel() {
        menuPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JButton addEmployeeBtn = new JButton("Add Employee");
        JButton removeEmployeeBtn = new JButton("Remove Employee");
        JButton listEmployeesBtn = new JButton("List Employees");
        JButton generatePayrollBtn = new JButton("Generate Payroll");
        JButton exitBtn = new JButton("Exit");


        addEmployeeBtn.addActionListener(e -> cardLayout.show(mainPanel, "AddEmployee"));
        removeEmployeeBtn.addActionListener(e -> {
            refreshEmployeeList();
            cardLayout.show(mainPanel, "RemoveEmployee");
        });
        listEmployeesBtn.addActionListener(e -> {
            displayEmployees();
            cardLayout.show(mainPanel, "ListEmployees");
        });
        generatePayrollBtn.addActionListener(e -> {
            refreshEmployeeListForPayroll();
            cardLayout.show(mainPanel, "GeneratePayroll");
        });
        exitBtn.addActionListener(e -> System.exit(0));


        menuPanel.add(addEmployeeBtn);
        menuPanel.add(removeEmployeeBtn);
        menuPanel.add(listEmployeesBtn);
        menuPanel.add(generatePayrollBtn);
        menuPanel.add(exitBtn);
    }


    private void createAddEmployeePanel() {
        addEmployeePanel = new JPanel(new BorderLayout(10, 10));
        addEmployeePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField deptField = new JTextField();
        JTextField salaryField = new JTextField();
        JTextField hoursField = new JTextField();


        formPanel.add(new JLabel("Employee ID (EMP-XXXX):"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Employee Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Department:"));
        formPanel.add(deptField);
        formPanel.add(new JLabel("Basic Salary:"));
        formPanel.add(salaryField);
        formPanel.add(new JLabel("Overtime Hours:"));
        formPanel.add(hoursField);


        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton submitBtn = new JButton("Submit");
        JButton backBtn = new JButton("Back to Menu");


        submitBtn.addActionListener(e -> {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String dept = deptField.getText().trim();
            String salaryText = salaryField.getText().trim();
            String hoursText = hoursField.getText().trim();


            if (!checker.isValidEmployeeId(id)) {
                showError(checker.getEmployeeIdErrorMessage(id));
                return;
            }
            if (!checker.isValidEmployeeName(name)) {
                showError(checker.getEmployeeNameErrorMessage(name));
                return;
            }
            if (dept.isEmpty()) {
                showError("Department cannot be empty");
                return;
            }


            try {
                double salary = Double.parseDouble(salaryText);
                int hours = Integer.parseInt(hoursText);


                if (!checker.isValidBasicSalary(salary)) {
                    showError(checker.getBasicSalaryErrorMessage(salary));
                    return;
                }


                if (!checker.isValidOvertimeHours(hours)) {
                    showError(checker.getOvertimeHoursErrorMessage(hours));
                    return;
                }


                Payroll emp = new Payroll();
                emp.setEmployeeId(id);
                emp.setEmployeeName(name);
                emp.setDepartment(dept);
                emp.setBasicSalary(salary);
                emp.setOvertimeHours(hours);
                db.addEmployee(emp);


                showSuccess("Employee added successfully!");
                idField.setText(""); nameField.setText("");
                deptField.setText(""); salaryField.setText(""); hoursField.setText("");
            } catch (NumberFormatException ex) {
                showError("Enter valid numbers for salary and hours.");
            }
        });


        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));
        buttonPanel.add(submitBtn);
        buttonPanel.add(backBtn);


        addEmployeePanel.add(formPanel, BorderLayout.CENTER);
        addEmployeePanel.add(buttonPanel, BorderLayout.SOUTH);
    }


    private void createRemoveEmployeePanel() {
        removeEmployeePanel = new JPanel(new BorderLayout());
        JComboBox<String> idComboBox = new JComboBox<>();
        removeEmployeePanel.add(new JLabel("Select Employee ID:"), BorderLayout.NORTH);
        removeEmployeePanel.add(idComboBox, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel();
        JButton removeBtn = new JButton("Remove");
        JButton backBtn = new JButton("Back to Menu");


        removeBtn.addActionListener(e -> {
            String id = (String) idComboBox.getSelectedItem();
            if (id != null && db.removeEmployeeById(id)) {
                showSuccess("Employee removed successfully!");
                refreshEmployeeList();
            } else {
                showError("Employee not found.");
            }
        });


        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));
        buttonPanel.add(removeBtn);
        buttonPanel.add(backBtn);
        removeEmployeePanel.add(buttonPanel, BorderLayout.SOUTH);
    }


    private void createListEmployeesPanel() {
        listEmployeesPanel = new JPanel(new BorderLayout());
        JTextArea employeeListArea = new JTextArea();
        employeeListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(employeeListArea);
        JButton backBtn = new JButton("Back to Menu");


        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));
        listEmployeesPanel.add(scrollPane, BorderLayout.CENTER);
        listEmployeesPanel.add(backBtn, BorderLayout.SOUTH);
    }


    private void createGeneratePayrollPanel() {
        generatePayrollPanel = new JPanel(new BorderLayout());
        JComboBox<String> idComboBox = new JComboBox<>();
        JTextArea payslipArea = new JTextArea();
        payslipArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(payslipArea);


        JPanel formPanel = new JPanel();
        formPanel.add(new JLabel("Select Employee ID:"));
        formPanel.add(idComboBox);


        JButton generateBtn = new JButton("Generate Payslip");
        JButton backBtn = new JButton("Back to Menu");


        generateBtn.addActionListener(e -> {
            String id = (String) idComboBox.getSelectedItem();
            Optional<Payroll> opt = db.getAllEmployees().stream()
                    .filter(emp -> emp.getEmployeeId().equals(id)).findFirst();


            if (opt.isPresent()) {
                Payroll emp = opt.get();
                new SalaryCalculation(emp).calculateAndStorePayroll();
                String payslip = generatePayslipText(emp);
                payslipArea.setText(payslip);
                payslipArea.setCaretPosition(0);


                try (FileWriter writer = new FileWriter(emp.getEmployeeName().replaceAll("[^a-zA-Z0-9]", "_") + "_payslip.txt")) {
                    writer.write(payslip);
                    showSuccess("Payslip file saved.");
                } catch (Exception ex) {
                    showError("Error saving file.");
                }
            } else {
                showError("Employee not found.");
            }
        });


        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));


        JPanel btnPanel = new JPanel();
        btnPanel.add(generateBtn);
        btnPanel.add(backBtn);


        generatePayrollPanel.add(formPanel, BorderLayout.NORTH);
        generatePayrollPanel.add(scrollPane, BorderLayout.CENTER);
        generatePayrollPanel.add(btnPanel, BorderLayout.SOUTH);
    }


    private String generatePayslipText(Payroll emp) {
        return String.format(
                "ABC Solutions - Employee Payslip (2025)\n" +
                        "=================================\n" +
                        "Employee ID: %s\nName: %s\nDepartment: %s\n\n" +
                        "EARNINGS\n" +
                        "Basic Salary: ₱ %.2f\nOvertime Pay: ₱ %.2f\nGross Pay: ₱ %.2f\n\n" +
                        "DEDUCTIONS (2025 rates)\n" +
                        "SSS Contribution: ₱ %.2f\nPhilHealth Contribution: ₱ %.2f\nPag-IBIG Contribution: ₱ %.2f\nIncome Tax: ₱ %.2f\n" +
                        "Total Deductions: ₱ %.2f\n\n" +
                        "=================================\nNET PAY: ₱ %.2f\n=================================\n",
                emp.getEmployeeId(), emp.getEmployeeName(), emp.getDepartment(),
                emp.getBasicSalary(), emp.getOvertimePay(), emp.getGrossPay(),
                emp.getSssContribution(), emp.getPhilHealthContribution(), emp.getPagIbigContribution(),
                emp.getIncomeTax(), emp.getTotalDeductions(), emp.getNetPay()
        );
    }


    private void refreshEmployeeList() {
        JComboBox<String> combo = (JComboBox<String>) ((BorderLayout) removeEmployeePanel.getLayout()).getLayoutComponent(BorderLayout.CENTER);
        combo.removeAllItems();
        db.getAllEmployees().forEach(emp -> combo.addItem(emp.getEmployeeId()));
    }


    private void refreshEmployeeListForPayroll() {
        JComboBox<String> combo = (JComboBox<String>) ((JPanel) generatePayrollPanel.getComponent(0)).getComponent(1);
        combo.removeAllItems();
        db.getAllEmployees().forEach(emp -> combo.addItem(emp.getEmployeeId()));
    }


    // ✅ Fixed method
    private void displayEmployees() {
        JTextArea area = (JTextArea) ((JScrollPane) listEmployeesPanel.getComponent(0)).getViewport().getView();
        area.setText("");


        if (db.getAllEmployees().isEmpty()) {
            area.setText("No employees to display.");
        } else {
            StringBuilder sb = new StringBuilder("Employee List:\n\n");
            db.getAllEmployees().forEach(emp -> sb.append(String.format(
                    "ID: %s, Name: %s, Dept: %s, Salary: %.2f, OT: %.0f\n",
                    emp.getEmployeeId(),
                    emp.getEmployeeName(),
                    emp.getDepartment(),
                    emp.getBasicSalary(),
                    emp.getOvertimeHours()
            )));
            area.setText(sb.toString());
        }
    }


    private void showError(String msg) {
        JOptionPane.showMessageDialog(mainFrame, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }


    private void showSuccess(String msg) {
        JOptionPane.showMessageDialog(mainFrame, msg, "Success", JOptionPane.INFORMATION_MESSAGE);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(PayrollSystemGUI::new);
    }
}
