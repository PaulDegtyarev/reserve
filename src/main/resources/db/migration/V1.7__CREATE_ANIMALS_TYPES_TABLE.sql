CREATE TABLE reserve.animals_types
(
    animal_id INT NOT NULL REFERENCES reserve.animals (id) ON DELETE CASCADE,
    type_id   INT NOT NULL REFERENCES reserve.types (id) ON DELETE CASCADE,
    PRIMARY KEY (animal_id, type_id)
);
