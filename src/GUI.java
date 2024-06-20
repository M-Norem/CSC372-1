import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class GUI {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("GUI Example");
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel
        JPanel panel = new JPanel();

        // Add a button to the panel
        JButton button = new JButton("That was easy!");
        panel.add(button);

        // Add the Panel with the Button to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Make the GUI / Frame visible
        frame.setVisible(true);
    }
}
