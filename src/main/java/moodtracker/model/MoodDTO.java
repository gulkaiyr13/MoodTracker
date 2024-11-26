package moodtracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import moodtracker.entity.MoodEntity;

import java.time.LocalDateTime;

@Getter
@Setter
public class MoodDTO {
    private Long id;
    private MoodType moodType;
    private String note;
    private LocalDateTime date;
}
