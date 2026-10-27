package com.vexor.api.services;

import com.vexor.api.domain.exercise.Exercise;
import com.vexor.api.repositories.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public List<Exercise> findAll() { return exerciseRepository.findAll(); }
}
