import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private final BankAccount account;
    private final JTextField balanceField;
    private final JTextField amountField;
    private final JLabel messageLabel;

    public GUI() {
        account = new BankAccount(0.0); // Initial balance is 0.0

        setTitle("Bank Balance Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        // Balance display
        panel.add(new JLabel("Current Balance:"));
        balanceField = new JTextField();
        balanceField.setEditable(false);
        panel.add(balanceField);

        // Amount input
        panel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        panel.add(amountField);

        // Deposit button
        JButton depositButton = new JButton("Deposit");
        panel.add(depositButton);
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    account.deposit(amount);
                    updateBalance();
                    messageLabel.setText("Amount deposited successfully.");
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Invalid amount.");
                }
            }
        });

        // Withdraw button
        JButton withdrawButton = new JButton("Withdraw");
        panel.add(withdrawButton);
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    account.withdraw(amount);
                    updateBalance();
                    messageLabel.setText("Amount withdrawn successfully.");
                } catch (NumberFormatException ex) {
                    messageLabel.setText("Invalid amount.");
                } catch (IllegalArgumentException ex) {
                    messageLabel.setText("Insufficient funds.");
                }
            }
        });

        add(panel, BorderLayout.CENTER);

        // Center the message label in the bottom part of the frame
        JPanel messagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        messageLabel = new JLabel(" ");
        messagePanel.add(messageLabel);
        add(messagePanel, BorderLayout.SOUTH);

        // Initialize balance display
        updateBalance();
    }

    private void updateBalance() {
        balanceField.setText(String.format("%.2f", account.getBalance()));
    }
}