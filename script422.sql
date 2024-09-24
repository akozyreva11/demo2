create table person (
id integer primary key,
name text,
age integer,
driver boolean,
car_id integer not null references car (id)
);

create table car(
id integer primary key,
marka text,
model text,
price integer
);
