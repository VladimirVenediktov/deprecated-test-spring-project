DROP TABLE IF EXISTS todo;
CREATE TABLE IF NOT EXISTS todo
(
    id varchar(36) not null primary key,
    description varchar(255) not null,
    created timestamp,
    modified timestamp,
    completed boolean
);

INSERT INTO todo (id, description, created, modified, completed) VALUES
(1, 'Cheese', '2021-12-10 00:00:000', '2021-12-10 00:01:000', false),
(2, 'Eggs', '2021-12-10 01:00:000', '2021-12-10 01:02:000', false),
(3, 'Milk', '2021-12-10 02:00:000', '2021-12-10 02:03:000', false);