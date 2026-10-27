create table if not exists workout_exercises (
    id uuid primary key default gen_random_uuid(),
    workout_id uuid references workouts(id) on delete cascade,
    exercise_id uuid references exercises(id) on delete cascade,
    sets integer,
    reps integer,
    weight double precision
);
