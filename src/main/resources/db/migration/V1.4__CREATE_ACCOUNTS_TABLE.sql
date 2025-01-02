CREATE TABLE reserve.accounts
(
    id        BIGSERIAL PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name  VARCHAR NOT NULL,
    email     VARCHAR(256) NOT NULL,
    password  TEXT NOT NULL,
    role      VARCHAR NOT NULL
);