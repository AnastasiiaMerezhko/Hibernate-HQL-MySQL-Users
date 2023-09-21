

CREATE DATABASE demo_db;


CREATE TABLE IF NOT EXISTS users
(
  user_name VARCHAR(128) NOT NULL PRIMARY KEY,
  first_name VARCHAR(128) NOT NULL,
  last_name VARCHAR(128) NOT NULL,
  email VARCHAR(128) NOT NULL
);


INSERT INTO User (userName, firstName, lastName, email) VALUES (:userName, :firstName, :lastName, :email)


FROM User


UPDATE User SET email = :email WHERE userName = :userName


DELETE FROM User WHERE userName = :userName