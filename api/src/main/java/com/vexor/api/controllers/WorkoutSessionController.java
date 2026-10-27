package com.vexor.api.controllers;

import com.vexor.api.domain.workout_session.WorkoutSession;
import com.vexor.api.services.WorkoutSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/workout-sessions")
@RequiredArgsConstructor
public class WorkoutSessionController {

    private final WorkoutSessionService workoutSessionService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WorkoutSession>> getByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(workoutSessionService.findByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<WorkoutSession> create(@RequestBody WorkoutSession session) {
        return ResponseEntity.ok(workoutSessionService.save(session));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkoutSession> update(@PathVariable UUID id, @RequestBody WorkoutSession session) {
        session.setId(id);
        return ResponseEntity.ok(workoutSessionService.save(session));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        workoutSessionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
