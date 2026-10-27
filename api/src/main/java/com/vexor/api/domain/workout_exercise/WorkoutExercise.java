package com.vexor.api.domain.workout_exercise;

import com.vexor.api.domain.exercise.Exercise;
import com.vexor.api.domain.workout.Workout;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "workout_exercises")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class WorkoutExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;
    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    private Integer sets;
    private Integer reps;
    private Double weight;
}
