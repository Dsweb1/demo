CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
create table if not exists cities
(
    name        varchar     not null,
    population  varchar     not null,
    country     varchar,
    UNIQUE      (name),
    PRIMARY KEY (name)
);
create table if not exists country
(
    id          uuid         not null,
    name        varchar(100) not null,
    capital     varchar,
    UNIQUE      (id),
    PRIMARY KEY (id)
);
ALTER TABLE country ADD CONSTRAINT fk_cities FOREIGN KEY (capital) references cities(name)
