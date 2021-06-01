
CREATE TABLE user (
	idUser VARCHAR(40) PRIMARY KEY NOT NULL,
	name VARCHAR(40) NOT NULL, 
	surname VARCHAR(40) NOT NULL,
	password VARCHAR(40) NOT NULL,
	age INTEGER, 
	player_id VARCHAR(40),
	money FLOAT
); 

CREATE TABLE product ( 
	idProduct VARCHAR(40) PRIMARY KEY NOT NULL,
	price FLOAT
)ENGINE = InnoDB; 

CREATE TABLE game (
	idGame VARCHAR(40) PRIMARY KEY NOT NULL,
	date DATE,
	duration FLOAT,
	levels_passed INTEGER, 
	player_id VARCHAR(40)
)ENGINE = InnoDB; 

CREATE TABLE userProducts (
	id_User VARCHAR(40) NOT NULL,
	id_Product VARCHAR(40) NOT NULL,
	cantidad INTEGER NOT NULL,
	FOREIGN KEY (id_User) REFERENCES user(idUser),
	FOREIGN KEY (id_Product) REFERENCES product(idProduct)
)ENGINE = InnoDB;

CREATE TABLE userGames (
	idUserGame VARCHAR(40) NOT NULL,
	id_Game VARCHAR(40) NOT NULL,
	FOREIGN KEY (idUserGame) REFERENCES user(idUser),
	FOREIGN KEY (id_Game) REFERENCES game(idGame)
)ENGINE = InnoDB;

INSERT INTO user VALUES('lau','Laura', 'Nuez', 'asdf', 22, '' , 200);