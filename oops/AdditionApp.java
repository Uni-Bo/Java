import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdditionApp {
    private JFrame frame = new JFrame("Addition Application");
    private JLabel label1 = new JLabel("Enter Number 1:");
    private JLabel label2 = new JLabel("Enter Number 2:");
    private JTextField textField1 = new JTextField(10);
    private JTextField textField2 = new JTextField(10);
    private JButton submitButton = new JButton("Submit");
    private JTextArea resultTextArea = new JTextArea(5, 20);

    public AdditionApp() {
        // Set the layout for the frame
        frame.setLayout(new BorderLayout());

        // Create a panel for labels and text fields
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(label1);
        inputPanel.add(textField1);
        inputPanel.add(label2);
        inputPanel.add(textField2);

        // Create a panel for the submit button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);

        // Add components to the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resultTextArea, BorderLayout.SOUTH);

        // Add an action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());
                    double result = num1 + num2;
                    resultTextArea.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    resultTextArea.setText("Invalid Input");
                }
            }
        });

        // Set frame properties
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdditionApp());
    }
}
