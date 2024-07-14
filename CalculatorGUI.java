import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    private JFrame frame;
    private JTextField textField;
    private double num1, num2, result;
    private String operator;

    public CalculatorGUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "sqrt", "C"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 24));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("C")) {
                textField.setText("");
                num1 = num2 = result = 0;
                operator = "";
            } else if (command.equals("=")) {
                num2 = Double.parseDouble(textField.getText());

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            JOptionPane.showMessageDialog(frame, "Ошибка: деление на ноль.");
                            return;
                        }
                        break;
                    case "sqrt":
                        if (num1 >= 0) {
                            result = Math.sqrt(num1);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Ошибка: отрицательное число под корнем.");
                            return;
                        }
                        break;
                }
                textField.setText(String.valueOf(result));
            } else if (command.equals("sqrt")) {
                num1 = Double.parseDouble(textField.getText());
                operator = command;
                textField.setText("sqrt(" + num1 + ")");
            } else if ("+-*/".contains(command)) {
                num1 = Double.parseDouble(textField.getText());
                operator = command;
                textField.setText("");
            } else {
                textField.setText(textField.getText() + command);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorGUI());
    }
}