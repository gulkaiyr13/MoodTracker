package repository;

import entity.MoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MoodEntryRepository extends JpaRepository<MoodEntry, Long> {
    List<MoodEntry> findAllByDateBetween(LocalDate startDate, LocalDate endDate);
}
