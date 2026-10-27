package com.vexor.api.repositories;

import com.vexor.api.domain.workout_session.WorkoutSession;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, UUID> {
    List<WorkoutSession> findByUserId(UUID userId);
}
