CREATE TABLE employee (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(50) NOT NULL,
	surname VARCHAR(50) NOT NULL,
	birth_date DATE NOT NULL,
	phone VARCHAR(20),
	salary FLOAT,
	position_id INTEGER
) WITH (
  OIDS=FALSE
);



CREATE TABLE position (
	id SERIAL PRIMARY KEY NOT NULL,
	position_name VARCHAR(50) NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE dish (
	id SERIAL PRIMARY KEY NOT NULL,
	dish_name VARCHAR(50) NOT NULL,
	category_id INTEGER NOT NULL,
	price FLOAT,
	weight FLOAT
) WITH (
  OIDS=FALSE
);



CREATE TABLE category_dish (
	id SERIAL PRIMARY KEY NOT NULL,
	category_name VARCHAR(20) NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE menu (
	id SERIAL PRIMARY KEY NOT NULL,
	menu_name VARCHAR(20) NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE ingredient (
	id SERIAL PRIMARY KEY NOT NULL,
	ingredient_name VARCHAR(20) NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE stock (
	ingredient_id SERIAL PRIMARY KEY NOT NULL,
	qty FLOAT NOT NULL DEFAULT 0
) WITH (
  OIDS=FALSE
);



CREATE TABLE recipe (
	id SERIAL PRIMARY KEY NOT NULL,
	dish_id INTEGER NOT NULL,
	ingredient_id INTEGER NOT NULL,
	qty FLOAT NOT NULL DEFAULT 0
) WITH (
  OIDS=FALSE
);



CREATE TABLE order_num (
	id SERIAL PRIMARY KEY NOT NULL,
	employee_id INTEGER NOT NULL,
	table_num INTEGER NOT NULL,
	date_order TIMESTAMP NOT NULL,
	open BOOLEAN NOT NULL DEFAULT 'True'
) WITH (
  OIDS=FALSE
);



CREATE TABLE order_detail (
	id SERIAL PRIMARY KEY NOT NULL,
	order_id INTEGER NOT NULL,
	dish_id INTEGER NOT NULL,
	qty FLOAT NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE prepared_dish (
	id SERIAL PRIMARY KEY NOT NULL,
	dish_id INTEGER NOT NULL,
	employee_id INTEGER NOT NULL,
	order_id INTEGER NOT NULL,
	prepare_date TIMESTAMP NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE menu_detail (
	id SERIAL PRIMARY KEY NOT NULL,
	menu_id INTEGER NOT NULL,
	dish_id INTEGER NOT NULL
) WITH (
  OIDS=FALSE
);



ALTER TABLE employee ADD CONSTRAINT employee_fk0 FOREIGN KEY (position_id) REFERENCES position(id);

ALTER TABLE dish ADD CONSTRAINT dish_fk0 FOREIGN KEY (category_id) REFERENCES category_dish(id);

ALTER TABLE stock ADD CONSTRAINT stock_fk0 FOREIGN KEY (ingredient_id) REFERENCES ingredient(id);

ALTER TABLE recipe ADD CONSTRAINT recipe_fk0 FOREIGN KEY (dish_id) REFERENCES dish(id);
ALTER TABLE recipe ADD CONSTRAINT recipe_fk1 FOREIGN KEY (ingredient_id) REFERENCES ingredient(id);

ALTER TABLE order_num ADD CONSTRAINT order_fk0 FOREIGN KEY (employee_id) REFERENCES employee(id);

ALTER TABLE order_detail ADD CONSTRAINT order_detail_fk0 FOREIGN KEY (order_id) REFERENCES order_num(id);
ALTER TABLE order_detail ADD CONSTRAINT order_detail_fk1 FOREIGN KEY (dish_id) REFERENCES dish(id);

ALTER TABLE prepared_dish ADD CONSTRAINT prepared_dish_fk0 FOREIGN KEY (dish_id) REFERENCES dish(id);
ALTER TABLE prepared_dish ADD CONSTRAINT prepared_dish_fk1 FOREIGN KEY (employee_id) REFERENCES employee(id);
ALTER TABLE prepared_dish ADD CONSTRAINT prepared_dish_fk2 FOREIGN KEY (order_id) REFERENCES order_num(id);

ALTER TABLE menu_detail ADD CONSTRAINT menu_detail_fk0 FOREIGN KEY (menu_id) REFERENCES menu(id);
ALTER TABLE menu_detail ADD CONSTRAINT menu_detail_fk1 FOREIGN KEY (dish_id) REFERENCES dish(id);
