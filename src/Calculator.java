import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subButton, mulButton, divButton, modButton, clearButton;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 300);  // Increase the size to accommodate all components
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());  // Use GridBagLayout for better control of component sizes

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);  // Add some padding

        JLabel firstNumberLabel = new JLabel("First Number:");
        firstNumberField = new JTextField();
        JLabel secondNumberLabel = new JLabel("Second Number:");
        secondNumberField = new JTextField();
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        clearButton = new JButton("Clear");

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        modButton.addActionListener(this);
        clearButton.addActionListener(this);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(firstNumberLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(firstNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(secondNumberLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(secondNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(resultLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(resultField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(addButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(subButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(mulButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(divButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(modButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(clearButton, gbc);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subButton) {
                result = num1 - num2;
            } else if (e.getSource() == mulButton) {
                result = num1 * num2;
            } else if (e.getSource() == divButton) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultField.setText("Cannot divide by 0");
                    return;
                }
            } else if (e.getSource() == modButton) {
                result = num1 % num2;
            } else if (e.getSource() == clearButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
