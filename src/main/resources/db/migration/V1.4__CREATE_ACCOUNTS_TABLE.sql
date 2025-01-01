CREATE TABLE reserve.accounts
(
    id        BIGSERIAL PRIMARY KEY,
    firstName VARCHAR NOT NULL,
    lastName  VARCHAR NOT NULL,
    email     VARCHAR(256) NOT NULL,
    password  TEXT NOT NULL,
    role      VARCHAR NOT NULL
);