create table if not exists workouts (
    id uuid primary key default gen_random_uuid(),
    name text not null,
    category text,
    notes text,
    user_id uuid not null references users(id) on delete cascade
);
