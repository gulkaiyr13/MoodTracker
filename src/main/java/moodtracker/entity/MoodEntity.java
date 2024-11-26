package moodtracker.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import moodtracker.model.MoodType;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "MOODS")
@FieldDefaults(level = AccessLevel.PRIVATE)
@SequenceGenerator(name = "MOODS_SEQUENCE", sequenceName = "MOODS_SEQ")
public class MoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private String note;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    private MoodType moodType;
}
