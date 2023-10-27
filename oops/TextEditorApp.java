import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditorApp {
    public static void main(String[] args) {
        // Create a JFrame (window)
        JFrame frame = new JFrame("Text Editor");

        // Create a JTextArea for text input
        JTextArea textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

        // Create a JScrollPane to scroll through text
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create a "Save" button
        JButton saveButton = new JButton("Save");

        // Create a "Load" button
        JButton loadButton = new JButton("Load");

        // Add an ActionListener to the "Save" button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = fileChooser.getSelectedFile();
                        FileWriter writer = new FileWriter(file);
                        writer.write(textArea.getText());
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Add an ActionListener to the "Load" button
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = fileChooser.getSelectedFile();
                        FileReader reader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(reader);
                        textArea.setText(""); // Clear the text area
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            textArea.append(line + "\n");
                        }
                        reader.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Set the layout for the frame
        frame.setLayout(new BorderLayout());

        // Add components to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(saveButton, BorderLayout.SOUTH);
        frame.add(loadButton, BorderLayout.NORTH);

        // Set frame properties
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
