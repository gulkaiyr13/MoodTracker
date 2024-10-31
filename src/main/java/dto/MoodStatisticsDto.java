package dto;

import entity.Mood;

public class MoodStatisticsDto {
    private Mood mood;
    private Long count;

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}