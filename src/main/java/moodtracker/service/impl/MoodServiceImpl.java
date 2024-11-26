package moodtracker.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import moodtracker.entity.MoodEntity;
import moodtracker.entity.UserEntity;
import moodtracker.exception.ResourceNotFoundException;
import moodtracker.mapper.MoodMapper;
import moodtracker.model.MoodDTO;
import moodtracker.repository.MoodRepository;
import moodtracker.repository.UserRepository;
import moodtracker.service.MoodService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MoodServiceImpl implements MoodService {
    MoodRepository moodRepository;
    UserRepository userRepository;
    MoodMapper moodMapper;

    @Override
    public MoodDTO addMood(MoodDTO moodDto, Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        MoodEntity moodEntity = moodMapper.toEntity(moodDto);
        moodEntity.setUser(user);

        return moodMapper.toDto(moodRepository.save(moodEntity));
    }

    @Override
    public MoodDTO getMoodById(Long moodId) {
        MoodEntity mood = moodRepository.findById(moodId)
                .orElseThrow(() -> new ResourceNotFoundException("Mood not found with id: " + moodId));
        return moodMapper.toDto(mood);
    }

    @Override
    public MoodDTO updateMood(MoodDTO updatedMoodDto) {
        return moodMapper.toDto(moodRepository.save(moodMapper.toEntity(updatedMoodDto)));
    }

    @Override
    public void deleteMood(Long moodId) {
        moodRepository.deleteById(moodId);
    }
}
