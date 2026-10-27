create table if not exists workout_sessions (
    id uuid primary key default gen_random_uuid(),
    started_at timestamp,
    finished_at timestamp,
    duration_minutes integer,
    user_id uuid references users(id) on delete cascade,
    workout_id uuid references workouts(id) on delete set null
);
