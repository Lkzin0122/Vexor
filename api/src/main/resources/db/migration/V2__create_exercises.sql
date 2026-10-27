create table if not exists exercises (
    id uuid primary key default gen_random_uuid(),
    name text not null,
    muscle_group text,
    equipment text,
    description text
);
