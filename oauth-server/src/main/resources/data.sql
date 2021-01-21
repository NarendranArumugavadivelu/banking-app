DROP TABLE IF EXISTS oauth_client_details;

CREATE TABLE oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY NOT NULL,
  client_secret VARCHAR(255) NOT NULL,
  web_server_redirect_uri VARCHAR(2048) DEFAULT NULL,
  scope VARCHAR(255) DEFAULT NULL,
  access_token_validity INT(11) DEFAULT NULL,
  refresh_token_validity INT(11) DEFAULT NULL,
  resource_ids VARCHAR(1024) DEFAULT NULL,
  authorized_grant_types VARCHAR(1024) DEFAULT NULL,
  authorities VARCHAR(1024) DEFAULT NULL,
  additional_information VARCHAR(4096) DEFAULT NULL,
  autoapprove VARCHAR(255) DEFAULT NULL
);

DROP TABLE IF EXISTS role;

CREATE TABLE role (
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) DEFAULT NULL,
);

DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(100) NOT NULL,
  password VARCHAR(1024) NOT NULL,
  email VARCHAR(1024) NOT NULL,
  enabled TINYINT(4) NOT NULL,
  account_non_expired TINYINT(4) NOT NULL,
  credentials_non_expired TINYINT(4) NOT NULL,
  account_non_locked TINYINT(4) NOT NULL,
);

DROP TABLE IF EXISTS role_user;

CREATE TABLE role_user (
  role_id INT(11) DEFAULT NULL,
  user_id int(11) DEFAULT NULL,
  FOREIGN KEY (role_id) REFERENCES role (id),
  FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE IF NOT EXISTS oauth_client_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_access_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication LONGVARBINARY,
  refresh_token VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_refresh_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication LONGVARBINARY,
);

CREATE TABLE IF NOT EXISTS oauth_code (
  code VARCHAR(256), 
  authentication VARBINARY
);

CREATE TABLE IF NOT EXISTS oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);

INSERT INTO oauth_client_details (
	client_id, 
	client_secret, 
	web_server_redirect_uri, 
	scope, 
	access_token_validity, 
	refresh_token_validity, 
	resource_ids, 
	authorized_grant_types, 
	additional_information) 
	VALUES (
	'client', 
	'{bcrypt}$2a$10$osa7/SmX5i7PSgq69.h3Yuqw1saZysWMnHUrqxXuvDB9GL/xl1Vr2', 
	'http://localhost:8080/code', 
	'READ,WRITE', 
	'3600', 
	'10000', 
	'account-service,bank-service', 
	'authorization_code,password,refresh_token,client_credentials', 
	'{}');
	
INSERT INTO role (name) VALUES ('ROLE_ADMIN'),('ROLE_USER');

INSERT INTO user (
	user_name,
	password, 
	email, 
	enabled, 
	account_non_expired, 
	credentials_non_expired, 
	account_non_locked) 
	VALUES (
		'rinat',
		'{bcrypt}$2a$10$7IferiBKCB5XpQz.IXGSVOAT7bR9ijKMTTPtKMBM8cYs8f4MLr1Ay', 
		'rinat@gmail.com', 
		'1', '1', '1', '1');
		
		
INSERT INTO user (
	user_name,
	password, 
	email, 
	enabled, 
	account_non_expired, 
	credentials_non_expired, 
	account_non_locked) 
	VALUES (
		'beck', 
		'{bcrypt}$2a$10$.D5nQpLJVELqA5QO1XO6LuiwIswc4ByfouOQ1kedCpbYToDW.784u',
		'beck@gmail.com', 
		'1', '1', '1', '1');

INSERT INTO role_user (role_id, user_id) VALUES (1, 1), (2, 2), (2, 1);	