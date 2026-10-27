package com.vexor.api.services;

import com.vexor.api.domain.workout_session.WorkoutSession;
import com.vexor.api.repositories.WorkoutSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkoutSessionService {
    private final WorkoutSessionRepository workoutSessionRepository;

    public List<WorkoutSession> findByUserId(UUID userId) { return workoutSessionRepository.findByUserId(userId); }
    public Optional<WorkoutSession> findById(UUID id) { return workoutSessionRepository.findById(id); }
    public WorkoutSession save(WorkoutSession session) { return workoutSessionRepository.save(session); }
    public void deleteById(UUID id) { workoutSessionRepository.deleteById(id); }
}
