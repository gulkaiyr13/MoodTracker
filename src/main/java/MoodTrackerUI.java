import javax.swing.*;
import java.awt.*;

public class MoodTrackerUI extends JFrame {
    private JComboBox<String> moodComboBox;
    private JTextField noteField;
    private JTextArea historyArea;

    public MoodTrackerUI() {
        setTitle("Mood Tracker");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel addMoodPanel = new JPanel(new GridLayout(3, 2));
        addMoodPanel.add(new JLabel("Mood:"));

        moodComboBox = new JComboBox<>(new String[]{"HAPPY", "SAD", "STRESSED", "TIRED", "NEUTRAL"});
        addMoodPanel.add(moodComboBox);

        addMoodPanel.add(new JLabel("Note:"));
        noteField = new JTextField();
        addMoodPanel.add(noteField);

        JButton addButton = new JButton("Add Mood");
        addButton.addActionListener(new AddMoodAction());
        addMoodPanel.add(addButton);

        add(addMoodPanel, BorderLayout.NORTH);

        historyArea = new JTextArea();
        historyArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel loadHistoryPanel = new JPanel();
        JButton loadButton = new JButton("Load Mood History");
        loadButton.addActionListener(new LoadHistoryAction(historyArea));
        loadHistoryPanel.add(loadButton);
        add(loadHistoryPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new AddMoodAction(moodComboBox, noteField));
        loadButton.addActionListener(new LoadHistoryAction(historyArea));
    }
}

