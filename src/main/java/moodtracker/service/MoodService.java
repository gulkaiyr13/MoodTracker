package moodtracker.service;

import moodtracker.model.MoodDTO;

public interface MoodService {
    MoodDTO addMood(MoodDTO moodDto, Long userId);
    MoodDTO getMoodById(Long moodId);
    MoodDTO updateMood(MoodDTO updatedMoodDto);
    void deleteMood(Long moodId);
}
