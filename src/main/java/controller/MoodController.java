package controller;

import dto.MoodEntryDto;
import entity.MoodEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.MoodEntryService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/moods")
public class MoodController {

    @Autowired
    private MoodEntryService moodEntryService;

    @PostMapping("/add")
    public ResponseEntity<MoodEntry> addMoodEntry(@RequestBody MoodEntryDto moodEntryDto) {
        MoodEntry newEntry = moodEntryService.addMoodEntry(moodEntryDto.getMood(), moodEntryDto.getNote());
        return ResponseEntity.ok(newEntry);
    }

//    @GetMapping("/history")
//    public ResponseEntity<List<MoodEntryDto>> getMoodHistory() {
//        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate;
//        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate;
//        List<MoodEntry> entries = moodEntryService.getEntriesByDateRange(startDate, endDate);
//        return ResponseEntity.ok(entries);
//    }
//
//    @GetMapping("/stats")
//    public ResponseEntity<List<MoodEntryDto>> getMoodStatistics() {
//        return ResponseEntity.ok(moodEntryService.getMoodStatisticsAsList());
//    }
}


