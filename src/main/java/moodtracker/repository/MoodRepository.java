package moodtracker.repository;

import moodtracker.entity.MoodEntity;
import org.springframework.data.repository.CrudRepository;

public interface MoodRepository extends CrudRepository<MoodEntity, Long> {
}
