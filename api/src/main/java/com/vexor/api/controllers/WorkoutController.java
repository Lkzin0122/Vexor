package com.vexor.api.controllers;

import com.vexor.api.domain.user.User;
import com.vexor.api.domain.workout.Workout;
import com.vexor.api.services.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Workout>> getByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(workoutService.findByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Workout> create(@RequestBody Workout workout) {
        return ResponseEntity.ok(workoutService.save(workout));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workout> update(@PathVariable UUID id, @RequestBody Workout workout) {
        workout.setId(id);
        return ResponseEntity.ok(workoutService.save(workout));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        workoutService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
