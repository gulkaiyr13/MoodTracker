import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import javax.swing.*;

public class LoadHistoryAction implements ActionListener {
    private JTextArea historyArea;

    public LoadHistoryAction(JTextArea historyArea) {
        this.historyArea = historyArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            URL url = new URL("http://localhost:8080/api/moods/history?startDate=" + LocalDate.now().minusDays(7) + "&endDate=" + LocalDate.now());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine).append("\n");
                }
                in.close();

                historyArea.setText(content.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Failed to load mood history.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
}
