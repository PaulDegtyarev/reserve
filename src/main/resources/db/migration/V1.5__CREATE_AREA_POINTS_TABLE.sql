CREATE TABLE reserve.area_points
(
    area_id  INT REFERENCES reserve.areas (id) ON DELETE CASCADE,
    point_id INT REFERENCES reserve.points (id) ON DELETE CASCADE,
    PRIMARY KEY (area_id, point_id)
);