--CREATE DATABASE book_store_2;

CREATE TABLE books (
	id SERIAL PRIMARY KEY,
	title VARCHAR(70) NOT NULL,
	author VARCHAR (70) NOT NULL,
	price NUMERIC NOT NULL
);

CREATE TABLE clients (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(70) NOT NULL,
	last_name VARCHAR (70) NOT NULL,
	money_spent NUMERIC
);

create table purchases (
	id SERIAL,
	book_id INTEGER REFERENCES books(id),
	client_id INTEGER REFERENCES clients(id),
	PRIMARY KEY (book_id, client_id)
);

insert into books(title, author, price) values('title1', 'author1', 12)
insert into clients(first_name, last_name, money_spent) values('first_name1', 'last_name1', 0)
insert into purchases(book_id, client_id) values(1, 1)

