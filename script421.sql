alter table students add CONSTRAINT age_constraint CHECK ( age > 16 ); // Возраст студента не может быть меньше 16 лет.
ALTER TABLE students ADD CONSTRAINT nickname_unique UNIQUE (name);
ALTER TABLE students COLUMN name SET NOT NULL;
ALTER TABLE facultys ADD CONSTRAINT color_name_unique UNIQUE (name, color);
ALTER TABLE students COLUMN age SET DEFAULT '20';

