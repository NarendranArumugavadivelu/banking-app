DROP TABLE IF EXISTS account;

CREATE TABLE account(
	id INT AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(250) NOT NULL,
	last_name VARCHAR(250) NOT NULL
);

INSERT INTO account (first_name, last_name) VALUES ('Max', 'Mustermann'); 
INSERT INTO account (first_name, last_name) VALUES ('Darth', 'Vader');
