DROP TABLE IF EXISTS mydb.city;
CREATE TABLE mydb.city (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    state VARCHAR(255),
    country VARCHAR(255)
);

DROP TABLE IF EXISTS mydb.USERS;
CREATE TABLE mydb.USERS(user_id int(8),
    user_name varchar(20),
    primary key(user_id)
    );


DROP TABLE IF EXISTS mydb.fruits;
CREATE TABLE mydb.fruits(id int AUTO_INCREMENT,
    name varchar(20),
    primary key(id)
    );

