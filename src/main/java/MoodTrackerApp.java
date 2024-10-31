import javax.swing.*;
import java.awt.*;

public class MoodTrackerApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MoodTrackerUI ui = new MoodTrackerUI();
            ui.setVisible(true);
        });
    }
}
