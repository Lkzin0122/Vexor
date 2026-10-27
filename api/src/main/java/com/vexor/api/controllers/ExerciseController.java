package com.vexor.api.controllers;

import com.vexor.api.domain.exercise.Exercise;
import com.vexor.api.services.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<List<Exercise>> getAll() {
        return ResponseEntity.ok(exerciseService.findAll());
    }
}
