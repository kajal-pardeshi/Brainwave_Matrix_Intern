import javax.swing.*;
import java.awt.*;
public class HospitalManagementSystemSwing extends JFrame 
{

    static Patient[] patients = new Patient[100];
    static Appointment[] appointments = new Appointment[100];
    static Staff[] staffMembers = new Staff[50];
    static String[][] inventory = new String[100][2];
    static int patientCount = 0;
    static int appointmentCount = 0;
    static int staffCount = 0;
    static int inventoryCount = 0;

    public HospitalManagementSystemSwing() 
    {
        setTitle("Hospital Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header
        JLabel header = new JLabel("Hospital Management System", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setOpaque(true);
        header.setBackground(new Color(70, 130, 180));
        header.setForeground(Color.WHITE);
        add(header, BorderLayout.NORTH);

        // Main panel with buttons
        JPanel mainPanel = new JPanel(new GridLayout(7, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton btnRegisterPatient = new JButton("Register Patient");
        JButton btnScheduleAppointment = new JButton("Schedule Appointment");
        JButton btnViewRecords = new JButton("View Patient Records");
        JButton btnBilling = new JButton("Billing and Invoicing");
        JButton btnManageInventory = new JButton("Manage Inventory");
        JButton btnManageStaff = new JButton("Manage Staff");
        JButton btnExit = new JButton("Exit");

        btnRegisterPatient.setBackground(new Color(144, 238, 144));
        btnScheduleAppointment.setBackground(new Color(173, 216, 230));
        btnViewRecords.setBackground(new Color(255, 228, 181));
        btnBilling.setBackground(new Color(250, 128, 114));
        btnManageInventory.setBackground(new Color(221, 160, 221));
        btnManageStaff.setBackground(new Color(240, 230, 140));
        btnExit.setBackground(new Color(255, 99, 71));
        
        btnExit.setForeground(Color.WHITE);

        btnRegisterPatient.addActionListener(e -> registerPatient());
        btnScheduleAppointment.addActionListener(e -> scheduleAppointment());
        btnViewRecords.addActionListener(e -> viewPatientRecords());
        btnBilling.addActionListener(e -> generateBill());
        btnManageInventory.addActionListener(e -> manageInventory());
        btnManageStaff.addActionListener(e -> manageStaff());
        btnExit.addActionListener(e -> System.exit(0));

        mainPanel.add(btnRegisterPatient);
        mainPanel.add(btnScheduleAppointment);
        mainPanel.add(btnViewRecords);
        mainPanel.add(btnBilling);
        mainPanel.add(btnManageInventory);
        mainPanel.add(btnManageStaff);
        mainPanel.add(btnExit);

        add(mainPanel, BorderLayout.CENTER);

        // Footer
        JLabel footer = new JLabel("© 2025 Hospital Management System", JLabel.CENTER);
        footer.setFont(new Font("Arial", Font.ITALIC, 12));
        footer.setOpaque(true);
        footer.setBackground(new Color(240, 248, 255));
        footer.setForeground(new Color(70, 130, 180));
        add(footer, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void registerPatient() 
    {
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField contactField = new JTextField();

        Object[] message = 
        {
            "Name:", nameField,
            "Age:", ageField,
            "Contact:", contactField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Register Patient", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) 
        {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String contact = contactField.getText();
            patients[patientCount++] = new Patient(name, age, contact);
            JOptionPane.showMessageDialog(this, "Patient registered successfully.");
        }
    }

    private void scheduleAppointment() 
    {
        JTextField patientNameField = new JTextField();
        JTextField doctorNameField = new JTextField();
        JTextField dateField = new JTextField();

        Object[] message = 
        {
            "Patient Name:", patientNameField,
            "Doctor Name:", doctorNameField,
            "Date (YYYY-MM-DD):", dateField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Schedule Appointment", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) 
        {
            String patientName = patientNameField.getText();
            String doctorName = doctorNameField.getText();
            String date = dateField.getText();
            appointments[appointmentCount++] = new Appointment(patientName, doctorName, date);
            JOptionPane.showMessageDialog(this, "Appointment scheduled successfully.");
        }
    }

    private void viewPatientRecords() 
    {
        if (patientCount == 0) 
        {
            JOptionPane.showMessageDialog(this, "No patients registered.");
        } else 
        {
            StringBuilder records = new StringBuilder();
            for (int i = 0; i < patientCount; i++) 
            {
                records.append(patients[i]).append("\n");
            }
            JOptionPane.showMessageDialog(this, records.toString(), "Patient Records", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void generateBill() 
    {
        JTextField patientNameField = new JTextField();
        JTextField amountField = new JTextField();

        Object[] message = 
        {
            "Patient Name:", patientNameField,
            "Amount:", amountField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Generate Bill", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) 
        {
            String patientName = patientNameField.getText();
            double amount = Double.parseDouble(amountField.getText());
            JOptionPane.showMessageDialog(this, "Invoice for " + patientName + " with amount $" + amount + " generated successfully.");
        }
    }

    private void manageInventory() 
    {
        JTextField itemNameField = new JTextField();
        JTextField quantityField = new JTextField();

        Object[] message = 
        {
            "Item Name:", itemNameField,
            "Quantity:", quantityField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Manage Inventory", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) 
        {
            String itemName = itemNameField.getText();
            String quantity = quantityField.getText();
            inventory[inventoryCount][0] = itemName;
            inventory[inventoryCount++][1] = quantity;
            JOptionPane.showMessageDialog(this, "Inventory updated.");
        }
    }

    private void manageStaff() 
    {
        JTextField nameField = new JTextField();
        JTextField positionField = new JTextField();

        Object[] message = 
        {
            "Name:", nameField,
            "Position:", positionField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Manage Staff", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) 
        {
            String name = nameField.getText();
            String position = positionField.getText();
            staffMembers[staffCount++] = new Staff(name, position);
            JOptionPane.showMessageDialog(this, "Staff member added successfully.");
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(HospitalManagementSystemSwing::new);
    }

    // Supporting Classes
    static class Patient 
    {
        String name;
        int age;
        String contact;

        Patient(String name, int age, String contact) 
        {
            this.name = name;
            this.age = age;
            this.contact = contact;
        }

        @Override
        public String toString() 
        {
            return "Patient{name='" + name + "', age=" + age + ", contact='" + contact + "'}";
        }
    }

    static class Appointment 
    {
        String patientName;
        String doctorName;
        String date;

        Appointment(String patientName, String doctorName, String date) 
        {
            this.patientName = patientName;
            this.doctorName = doctorName;
            this.date = date;
        }
    
        @Override
        public String toString() 
        {
            return "Appointment{patientName='" + patientName + "', doctorName='" + doctorName + "', date='" + date + "'}";
        }
    }
    
    static class Staff 
    {
        String name;
        String position;
    
        Staff(String name, String position) 
        {
            this.name = name;
            this.position = position;
        }
    
        @Override
        public String toString() 
        {
            return "Staff{name='" + name + "', position='" + position + "'}";
        }
    }
    
}