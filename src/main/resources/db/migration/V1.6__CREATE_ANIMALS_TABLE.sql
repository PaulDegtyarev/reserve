CREATE TABLE reserve.animals
(
    id                   BIGSERIAL PRIMARY KEY,
    weight               FLOAT NOT NULL,
    length               FLOAT NOT NULL,
    height               FLOAT NOT NULL,
    gender               VARCHAR NOT NULL,
    life_status          VARCHAR NOT NULL,
    death_datetime       TIMESTAMP,
    chipping_datetime    TIMESTAMP NOT NULL,
    chipper_id           INT NOT NULL REFERENCES reserve.accounts (id) ON DELETE RESTRICT,
    chipping_location_id INT NOT NULL REFERENCES reserve.points (id) ON DELETE RESTRICT
);