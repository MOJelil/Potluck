BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	firstName		varchar(50)	not null,
	lastName		varchar(50)	not null,
	phone			varchar(50)	not null,
	email			varchar(50)	not null,
	username 		varchar(50) NOT NULL,
	password_hash 	varchar(200) NOT NULL,
	role 			varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (firstName, lastName, phone, email, username,password_hash,role) VALUES ('firstName', 'lastName', 'phone', 'email','user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (firstName, lastName, phone, email,username,password_hash,role) VALUES ('John', 'Admin', 'phone', 'email','admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (firstName, lastName, phone, email,username,password_hash,role) VALUES ('Test', 'User', '592-3767', 'rob@hotmail.com','test','password','ROLE_ADMIN');


COMMIT TRANSACTION;
