CREATE TABLE IF NOT EXISTS "inventory_model" (
  id bigserial primary key,
  buying_date varchar(255) not null,
  category varchar (255) not null,
  code varchar(255) not null,
  initial_value INTEGER not null,
  manufacture varchar(255) not null,
  name_product varchar(255) not null,
  description varchar(255) not null,
  status varchar(255) not null,
  place_residence varchar(255) not null,
  employee_model_id bigserial,
  FOREIGN KEY (employee_model_id) REFERENCES employee_model (id)
);