CREATE TABLE reserve.animal_visited_locations
(
    animal_id      INT REFERENCES reserve.animals (id) ON DELETE CASCADE,
    point_id       INT REFERENCES reserve.points (id) ON DELETE CASCADE,
    visit_datetime TIMESTAMP NOT NULL,
    PRIMARY KEY (animal_id, point_id)
);