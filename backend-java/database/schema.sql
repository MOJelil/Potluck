BEGIN TRANSACTION;

DROP TABLE IF EXISTS dietary_restrictions;
DROP TABLE IF EXISTS potluck;
DROP TABLE IF EXISTS guests;
DROP TABLE IF EXISTS dish_potluck;
DROP TABLE IF EXISTS dish;
DROP TABLE IF EXISTS gueststable;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_diet;
DROP TABLE IF EXISTS dish_restriction;






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
	servings		int				NOT NULL,
	potluck_id 		int 			NOT NULL references potluck (potluck_id),
	recipe			varchar(250),
	user_id			int,
	PRIMARY KEY (dish_id)

);


CREATE TABLE dish_potluck (	
	dish_id 		int	    NOT NULL references dish (dish_id),
	potluck_id 		int     NOT NULL references potluck (potluck_id),
	PRIMARY KEY (dish_id, potluck_id)
);

CREATE TABLE dish_restriction (
	dish_id  	 	int 	NOT NULL references dish (dish_id),    
	dietary_id   	int 	Not NULL references dietary_restrictions (dietary_id),
	PRIMARY KEY (dish_id, dietary_id)
);

-- CREATE DEMO USERS (users)
INSERT INTO users (firstname, lastname, phone, email, username, password_hash, role) VALUES ('Andie', 'Vester', '513-222-2222', 'avester@gmail.com', 'andie', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER');
INSERT INTO users (firstname, lastname, phone, email, username, password_hash, role) VALUES ('Mhamed', 'Jelil', '513-111-1234', 'mjelil@gmail.com', 'mhamed', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER');
INSERT INTO users (firstname, lastname, phone, email, username, password_hash, role) VALUES ('Steve', 'Long', '937-333-3333', 'slong@hotmail.com', 'steve', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER');
INSERT INTO users (firstname, lastname, phone, email, username, password_hash, role) VALUES ('Rob', 'van der Roest', '513-333-3333', 'robv@hotmail.com', 'rob', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER');  
INSERT INTO users (firstname, lastname, phone, email, username, password_hash, role) VALUES ('Charlie', 'Kelly', '513-678-1234', 'ckelly@gmail.com', 'charlie', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER');
INSERT INTO users (firstname, lastname, phone, email, username, password_hash, role) VALUES ('Dennis', 'Reynolds', '513-777-1234', 'dreynolds@gmail.com', 'dennis', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER');
INSERT INTO users (firstname, lastname, phone, email, username, password_hash, role) VALUES ('Dee', 'Reynolds', '513-678-5555', 'dreynolds2@hotmail.com', 'dee', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER');
INSERT INTO users (firstname, lastname, phone, email, username, password_hash, role) VALUES ('Mac', 'McDonald', '513-678-7728', 'mmcdonald@gmail.com', 'mac', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER');
INSERT INTO users (firstname, lastname, phone, email, username, password_hash, role) VALUES ('Frank', 'Reynolds', '513-554-5544', 'freynolds@gmail.com', 'frank', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER');

-- CREATE DEMO USER DIETS (user_diet)
INSERT INTO user_diet (user_id, dietary_id) VALUES (3, 2);
INSERT INTO user_diet (user_id, dietary_id) VALUES (4, 4);
INSERT INTO user_diet (user_id, dietary_id) VALUES (5, 1);
INSERT INTO user_diet (user_id, dietary_id) VALUES (5, 6);
INSERT INTO user_diet (user_id, dietary_id) VALUES (6, 1);
INSERT INTO user_diet (user_id, dietary_id) VALUES (7, 2);
INSERT INTO user_diet (user_id, dietary_id) VALUES (7, 6);
INSERT INTO user_diet (user_id, dietary_id) VALUES (8, 4);
INSERT INTO user_diet (user_id, dietary_id) VALUES (9, 1);
INSERT INTO user_diet (user_id, dietary_id) VALUES (10, 5);
INSERT INTO user_diet (user_id, dietary_id) VALUES (11, 3);


-- CREATE DEMO POTLUCKS (potluck)
INSERT INTO potluck (name, location, potluck_date, potluck_time, user_id, description, guests, appetizers, entrees, side_dishes, desserts, alcohol, non_alcohol) VALUES ('Graduation Potluck', 'Ault Park', 'Fri Aug 21 2020 00:00:00', '00:30:00', 6, 'Tech Elevator graduation celebration', 10, 3, 4, 3, 2, 3, 2); 
INSERT INTO potluck (name, location, potluck_date, potluck_time, user_id, description, guests, appetizers, entrees, side_dishes, desserts, alcohol, non_alcohol) VALUES ('Labor Day Potluck', 'Rob''s House', 'Fri Aug 28 2020 00:00:00', '00:30:00', 6, 'Annual Labor Day celebration', 5, 1, 3, 3, 2, 3, 2);
INSERT INTO potluck (name, location, potluck_date, potluck_time, user_id, description, guests, appetizers, entrees, side_dishes, desserts, alcohol, non_alcohol) VALUES ('Mac''s Birthday Potluck', 'Mac''s House', 'Fri Sep 25 2020 00:00:00', '00:30:00', 6, '30th Birthday celebration', 5, 1, 3, 3, 2, 3, 2);
INSERT INTO potluck (name, location, potluck_date, potluck_time, user_id, description, guests, appetizers, entrees, side_dishes, desserts, alcohol, non_alcohol) VALUES ('Halloween Potluck', 'Mhamed''s House', 'Sat Oct 31 2020 00:00:00', '00:30:00', 6, 'Spooky themed potluck', 5, 1, 3, 3, 2, 3, 2);
INSERT INTO potluck (name, location, potluck_date, potluck_time, user_id, description, guests, appetizers, entrees, side_dishes, desserts, alcohol, non_alcohol) VALUES ('Thanksgiving Potluck', 'Steve''s House', 'Sat Nov 21 2020 00:00:00', '00:30:00', 6, 'Friends Thanksgiving potluck', 5, 1, 3, 3, 2, 3, 2);
INSERT INTO potluck (name, location, potluck_date, potluck_time, user_id, description, guests, appetizers, entrees, side_dishes, desserts, alcohol, non_alcohol) VALUES ('Holiday Potluck', 'Andie''s House', 'Sat Dec 19 2020 00:00:00', '00:30:00', 6, 'Friends Holiday potluck', 5, 1, 3, 3, 2, 3, 2);

-- CREATE DEMO GUESTS (guests)
INSERT INTO guests (user_id, potluck_id) VALUES (3, 1);
INSERT INTO guests (user_id, potluck_id) VALUES (4, 1);
INSERT INTO guests (user_id, potluck_id) VALUES (5, 1);
INSERT INTO guests (user_id, potluck_id) VALUES (7, 1);
INSERT INTO guests (user_id, potluck_id) VALUES (8, 1);
INSERT INTO guests (user_id, potluck_id) VALUES (9, 1);
INSERT INTO guests (user_id, potluck_id) VALUES (10, 1);
INSERT INTO guests (user_id, potluck_id) VALUES (11, 1);

-- CREATE DEMO DISHES (AFTER CREATE POTLUCKS) (dish)
INSERT INTO dish (dish_name, category, servings, potluck_id, user_id) VALUES ('Maple Sausage-Cheese Balls', 'Appetizer', 10, 1, 1);
INSERT INTO dish (dish_name, category, servings, potluck_id, user_id) VALUES ('Watermelon Salsa', 'Appetizer', 12, 1, 2);
INSERT INTO dish (dish_name, category, servings, potluck_id, user_id) VALUES ('Nashville Hot Chicken Dip', 'Appetizer', 6, 1, 3);
INSERT INTO dish (dish_name, category, servings, potluck_id, user_id) VALUES ('Sloppy Joes', 'Entree', 8, 1, 4);
INSERT INTO dish (dish_name, category, servings, potluck_id, user_id) VALUES ('Veggie Chili', 'Entree', 4, 1, 3);
INSERT INTO dish (dish_name, category, servings, potluck_id, recipe, user_id) VALUES ('Hamburgers', 'Entree', 6, 1, 'Oscar Myer hamburgers.', 5);
INSERT INTO dish (dish_name, category, servings, potluck_id, user_id) VALUES ('Baked Ziti', 'Entree', 10, 1, 6);
INSERT INTO dish (dish_name, category, servings, potluck_id, user_id) VALUES ('Baked Beans', 'Side Dish', 8, 1, 7);
INSERT INTO dish (dish_name, category, servings, potluck_id, user_id) VALUES ('Mac''s Famous Mac and Cheese', 'Side Dish', 10, 1, 10);
INSERT INTO dish (dish_name, category, servings, potluck_id, user_id) VALUES ('Pasta Salad', 'Side Dish', 6, 1, 8);
INSERT INTO dish (dish_name, category, servings, potluck_id, user_id) VALUES ('Cherry Pie', 'Dessert', 10, 1, 9);
INSERT INTO dish (dish_name, category, servings, potluck_id, user_id) VALUES ('Ice Cream', 'Dessert', 10, 1, 10);
INSERT INTO dish (dish_name, category, servings, potluck_id, recipe, user_id) VALUES ('Screwdrivers', 'Alcoholic Beverage', 10, 1, 'Voda and orange juice.', 1);
INSERT INTO dish (dish_name, category, servings, potluck_id, user_id) VALUES ('Beer', 'Alcoholic Beverage', 20, 1, 3);
INSERT INTO dish (dish_name, category, servings, potluck_id, user_id) VALUES ('Champagne', 'Alcoholic Beverage', 10, 1, 7);
INSERT INTO dish (dish_name, category, servings, potluck_id, user_id) VALUES ('Fruit Punch', 'Non-Alcoholic Beverage', 4, 1, 10);
INSERT INTO dish (dish_name, category, servings, potluck_id, user_id) VALUES ('Lemonade', 'Non-Alcoholic Beverage', 5, 1, 9);

-- CREATE DEMO DIETARY RESTRICTIONS FOR DISH (AFTER CREATE NEW DISH) (dish_restriction)
INSERT INTO dish_restriction (dish_id, dietary_id) VALUES (1, 1);
INSERT INTO dish_restriction (dish_id, dietary_id) VALUES (1, 2);


COMMIT TRANSACTION;




