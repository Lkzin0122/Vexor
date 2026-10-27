package com.vexor.api.repositories;

import com.vexor.api.domain.workout.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface WorkoutRepository extends JpaRepository<Workout, UUID> {
    List<Workout> findByUserId(UUID userId);
}
