package service;

import entity.Mood;
import entity.MoodEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MoodEntryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MoodEntryService {

    @Autowired
    private MoodEntryRepository moodEntryRepository;

    public MoodEntry addMoodEntry(Mood mood, String note) {
        MoodEntry entry = new MoodEntry();
        entry.setMood(mood);
        entry.setNote(note);
        entry.setDate(LocalDate.now());
        return moodEntryRepository.save(entry);
    }

    public List<MoodEntry> getEntriesByDateRange(LocalDate startDate, LocalDate endDate) {
        return moodEntryRepository.findAllByDateBetween(startDate, endDate);
    }

    public Map<Mood, Long> getMoodStatistics() {
        return moodEntryRepository.findAll().stream().collect(Collectors.groupingBy(MoodEntry::getMood, Collectors.counting()));
    }

//    public List<MoodStatisticsDto> getMoodStatisticsAsList() {
//        Object entry;
//        return getMoodStatisticsAsList().set()
//                .stream().map(entry -> new MoodStatisticsDto(entry.getKey(), entry.getValue()))
//                .collect(Collectors.toList());
//    }
}
