CREATE TABLE IF NOT EXISTS "employee_model" (
  id bigserial primary key,
  email varchar(255) not null,
  enabled boolean,
  login varchar(255) not null,
  name varchar(255) not null,
  password varchar(255) not null,
  phone varchar(255) not null,
  region_responsibility varchar(255) not null,
  role varchar(255) not null,
  surname varchar(255) not null
);