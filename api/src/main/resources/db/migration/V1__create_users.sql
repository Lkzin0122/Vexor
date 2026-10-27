create table if not exists users (
    id uuid primary key default gen_random_uuid(),
    name text,
    username text unique,
    email text unique not null,
    password text,
    firebase_uid text unique,
    created_at timestamp
);
