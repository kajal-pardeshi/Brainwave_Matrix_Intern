import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class atm extends JFrame implements ActionListener {
    private double balance = 1000.00; // Initial balance
    private JLabel label;
    private JButton btnBalance, btnDeposit, btnWithdraw, btnExit;

    public atm() {
        setTitle("ATM Interface");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.LIGHT_GRAY);

        label = new JLabel("Welcome to the ATM Interface");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        add(label);

        btnBalance = new JButton("Check Balance");
        btnDeposit = new JButton("Deposit Money");
        btnWithdraw = new JButton("Withdraw Money");
        btnExit = new JButton("Exit");

        btnBalance.addActionListener(this);
        btnDeposit.addActionListener(this);
        btnWithdraw.addActionListener(this);
        btnExit.addActionListener(this);

        add(btnBalance);
        add(btnDeposit);
        add(btnWithdraw);
        add(btnExit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBalance) {
            JOptionPane.showMessageDialog(this, "Current Balance: $" + balance);
        } else if (e.getSource() == btnDeposit) {
            String input = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
            if (input != null) {
                try {
                    double amount = Double.parseDouble(input);
                    if (amount > 0) {
                        balance += amount;
                        JOptionPane.showMessageDialog(this, "Deposited: $" + amount);
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid number.");
                }
            }
        } else if (e.getSource() == btnWithdraw) {
            String input = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
            if (input != null) {
                try {
                    double amount = Double.parseDouble(input);
                    if (amount > 0 && amount <= balance) {
                        balance -= amount;
                        JOptionPane.showMessageDialog(this, "Withdrawn: $" + amount);
                    } else if (amount > balance) {
                        JOptionPane.showMessageDialog(this, "Insufficient funds.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid number.");
                }
            }
        } else if (e.getSource() == btnExit) {
            JOptionPane.showMessageDialog(this, "Thank you for using the ATM.");
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new atm());
    }
}