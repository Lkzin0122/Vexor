package com.vexor.api.services;

import com.vexor.api.domain.workout.Workout;
import com.vexor.api.repositories.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    public List<Workout> findByUserId(UUID userId) { return workoutRepository.findByUserId(userId); }
    public Optional<Workout> findById(UUID id) { return workoutRepository.findById(id); }
    public Workout save(Workout workout) { return workoutRepository.save(workout); }
    public void deleteById(UUID id) { workoutRepository.deleteById(id); }
}
