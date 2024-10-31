package dto;

import entity.Mood;

public class MoodEntryDto {
    private Mood mood;
    private String note;

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
