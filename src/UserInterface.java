import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UserInterface extends JFrame {

    private final JTextArea textArea;
    private final JPanel panel;

    public UserInterface() {
        // Set up the frame
        setTitle("Color-Changing User Interface");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel and set its background color to orange
        panel = new JPanel();
        add(panel);

        // Create the text area and add it to the panel
        textArea = new JTextArea();
        // Make text area non-interactable
        textArea.setEditable(false);
        textArea.setFocusable(false);
        // Enable word wrapping to hide horizontal scroll bar
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        panel.add(textArea, BorderLayout.CENTER);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        // Create menu items
        JMenuItem dateTimeItem = new JMenuItem("Print Date and Time");
        JMenuItem saveToFileItem = new JMenuItem("Save to File");
        JMenuItem changeColorItem = new JMenuItem("Change Background Color");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add menu items to menu
        menu.add(dateTimeItem);
        menu.add(saveToFileItem);
        menu.add(changeColorItem);
        menu.add(exitItem);

        // Add menu to menu bar
        menuBar.add(menu);

        // Set the menu bar for the frame
        setJMenuBar(menuBar);

        // Add action listeners for menu items
        dateTimeItem.addActionListener(e -> printDateTime());
        saveToFileItem.addActionListener(e -> saveToFile());
        changeColorItem.addActionListener(e -> changeBackgroundColor());
        exitItem.addActionListener(e -> System.exit(0));

        // Make the frame visible
        setVisible(true);
    }

    private void printDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateTime = formatter.format(date);
        textArea.setColumns(11); // Set fixed number of columns
        textArea.setRows(1); // Set fixed number of rows
        // Set text
        textArea.setText(dateTime);
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            String text = textArea.getText();
            writer.write(text);
            writer.newLine();
            textArea.setText("Contents saved to log.txt");
            textArea.setColumns(13); // Set fixed number of columns
            textArea.setRows(1); // Set fixed number of rows
        } catch (IOException ex) {
            textArea.setText("Error saving to file: " + ex.getMessage());
            textArea.setColumns(13); // Set fixed number of columns
            textArea.setRows(1); // Set fixed number of rows
        }
    }

    private void changeBackgroundColor() {
        Random random = new Random();
        float hue = random.nextFloat(); // Random hue for the color
        Color randomColor = Color.getHSBColor(hue, 0.8f, 1.0f); // High saturation and brightness for vibrant colors
        panel.setBackground(randomColor);
        textArea.setText("Background color changed to " + String.format("%.4f", hue));
        textArea.setColumns(19); // Set fixed number of columns
        textArea.setRows(1); // Set fixed number of rows
    }
}
