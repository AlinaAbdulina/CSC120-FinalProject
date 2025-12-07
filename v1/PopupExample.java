import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PopupExample {
    public static void main(String[] args) {
        // Simple message dialog

        ImageIcon imageIcon = new ImageIcon("imgs/explode!!!.gif");
        JOptionPane.showMessageDialog(null, imageIcon, "Image Pop-up", JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null, "This is a simple pop-up message.");

        // Input dialog
        String name = JOptionPane.showInputDialog(null, "What is your name?");
        if (name != null && !name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hello, " + name + "!");
        }

        // Confirmation dialog
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "You chose to continue.");
        } else {
            JOptionPane.showMessageDialog(null, "You chose not to continue.");
        }
    }
}