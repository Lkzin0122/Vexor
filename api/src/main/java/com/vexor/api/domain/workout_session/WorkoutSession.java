package com.vexor.api.domain.workout_session;

import com.vexor.api.domain.user.User;
import com.vexor.api.domain.workout.Workout;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "workout_sessions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class WorkoutSession {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;
    private Integer durationMinutes;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;
}
