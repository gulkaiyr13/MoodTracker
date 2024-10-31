import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AddMoodAction implements ActionListener {
    private JComboBox<String> moodComboBox;
    private JTextField noteField;

    public AddMoodAction(JComboBox<String> moodComboBox, JTextField noteField) {
        this.moodComboBox = moodComboBox;
        this.noteField = noteField;
    }

    public AddMoodAction() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String mood = (String) moodComboBox.getSelectedItem();
        String note = noteField.getText();
        try {
            URL url = new URL("http://localhost:8080/api/moods/add");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = String.format("{\"mood\": \"%s\", \"note\": \"%s\"}", mood, note);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                JOptionPane.showMessageDialog(null, "Mood added successfully!");
                noteField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add mood.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
}
