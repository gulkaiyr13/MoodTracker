package moodtracker.controller;

import lombok.RequiredArgsConstructor;
import moodtracker.model.MoodDTO;
import moodtracker.service.impl.MoodServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moods")
@RequiredArgsConstructor
public class MoodController {

    private final MoodServiceImpl moodService;

    @PostMapping
    public ResponseEntity<MoodDTO> addMood(@RequestBody MoodDTO moodDto, @RequestParam Long userId) {
        return ResponseEntity.ok(moodService.addMood(moodDto, userId));
    }

    @GetMapping("/mood/{id}")
    public ResponseEntity<MoodDTO> getMoodById(@PathVariable Long id) {
        return ResponseEntity.ok(moodService.getMoodById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MoodDTO> updateMood(@RequestBody MoodDTO moodDto) {
        return ResponseEntity.ok(moodService.updateMood(moodDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMood(@PathVariable Long id) {
        moodService.deleteMood(id);
        return ResponseEntity.noContent().build();
    }
}
