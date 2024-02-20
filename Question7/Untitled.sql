CREATE database Project;
use Project;
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);


CREATE TABLE posts (
    post_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    content TEXT NOT NULL
);


CREATE TABLE connections (
    connection_id INT AUTO_INCREMENT PRIMARY KEY,
    follower_username VARCHAR(255) NOT NULL,
    followee_username VARCHAR(255) NOT NULL,
    INDEX (follower_username),
    INDEX (followee_username)
);