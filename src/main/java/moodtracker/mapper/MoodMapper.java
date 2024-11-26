package moodtracker.mapper;

import moodtracker.entity.MoodEntity;
import moodtracker.model.MoodDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MoodMapper {

    MoodEntity toEntity(MoodDTO moodDto);

    MoodDTO toDto(MoodEntity moodEntity);
}
