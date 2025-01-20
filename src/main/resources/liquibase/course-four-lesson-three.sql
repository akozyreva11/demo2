-- liquibase formatted sql

-- changeset kozyreva:1
create index student_name_index on studentы (name);
-- changeset kozyreva:2
create index faculty_nc_index on facultys (name,color);