BEGIN TRANSACTION;

DROP TABLE IF EXISTS dietary_restrictions;
DROP TABLE IF EXISTS potluck;
DROP TABLE IF EXISTS guests;
DROP TABLE IF EXISTS dish_potluck;
<<<<<<< HEAD
DROP TABLE IF EXISTS dish;
DROP TABLE IF EXISTS gueststable;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_diet;
=======
DROP TABLE IF EXISTS dish_restriction;



>>>>>>> 8c229b51a0d825d4bd3236eeeb06d54aa7a038c6


CREATE TABLE users (
	user_id 		SERIAL NOT NULL,
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



CREATE TABLE dietary_restrictions (
	dietary_id 			SERIAL NOT NULL,
	restriction_name	varchar(50),
	PRIMARY KEY (dietary_id)
);

INSERT INTO dietary_restrictions(restriction_name) VALUES ('Vegan' ),
														  ('Vegetarian'),
														  ('Lactose Intolerant'),
														  ('Nut Allergy'),
														  ('Gluten Allergy'),
														  ('Halal'), 
														  ('Kosher'),
														  ('Shellfish Allergy');
														  
CREATE TABLE user_diet (
	
	user_id  	 int NOT NULL references users (user_id),    
	dietary_id   int Not NULL references dietary_restrictions (dietary_id),	
	PRIMARY KEY (user_id, dietary_id)
	
);

CREATE TABLE potluck (
	potluck_id 		SERIAL NOT NULL,
	name			varchar(50)		NOT NULL,
	location		varchar(50)		NOT NULL,
	potluck_date	DATE 			NOT NULL,
	potluck_time	TIME			NOT NULL,
	user_id 		int				NOT NULL references users (user_id),
	description		varchar(250)	NOT NULL,
	guests			int,
	appetizers		int,
	entrees			int,
	side_dishes		int,
	desserts        int,
	alcohol			int,
	non_alcohol     int,
	PRIMARY KEY (potluck_id)
);


CREATE TABLE guests (
	
	user_id 		int	    NOT NULL references users (user_id),
	potluck_id 		int     NOT NULL references potluck (potluck_id),
	PRIMARY KEY (user_id, potluck_id)
);


CREATE TABLE dish (
	dish_id 		SERIAL 			NOT NULL,
	dish_name		varchar(50)		NOT NULL,
	category		varchar(250)	NOT NULL,
<<<<<<< HEAD
	serving_number	int				NOT NULL,
	dietary_id		int 			NOT NULL references dietary_restrictions (dietary_id),
	potluck_id 		int 			NOT NULL references potluck (potluck_id),
=======
	servings		int				NOT NULL,
	potluck_id 		int 			NOT NULL,
>>>>>>> 8c229b51a0d825d4bd3236eeeb06d54aa7a038c6
	recipe			varchar(250)	NOT NULL,
	user_id			int,
	
<<<<<<< HEAD
	PRIMARY KEY (dish_id)
=======
	CONSTRAINT PK_dish PRIMARY KEY (dish_id),
	CONSTRAINT fk_potluck foreign key (potluck_id) references potluck (potluck_id)
>>>>>>> 8c229b51a0d825d4bd3236eeeb06d54aa7a038c6
);


CREATE TABLE dish_potluck (
	
	dish_id 		int	    NOT NULL references dish (dish_id),
	potluck_id 		int     NOT NULL references potluck (potluck_id),
	PRIMARY KEY (dish_id, potluck_id)
);

CREATE TABLE dish_restriction (
	dish_id  	 	int 	NOT NULL,    
	dietary_id   	int 	Not NULL,
	PRIMARY KEY (dish_id, dietary_id),
	CONSTRAINT fk_dish foreign key (dish_id) references dish (dish_id),
	CONSTRAINT fk_dietary_restrictions foreign key (dietary_id) references dietary_restrictions (dietary_id)
);

COMMIT TRANSACTION;




