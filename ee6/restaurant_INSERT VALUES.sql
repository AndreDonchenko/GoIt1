INSERT INTO position (position_Name) VALUES ('Director'), ('Account'), ('Cook'), ('Waiter');

INSERT INTO employee (name, surname, birth_date, phone, salary, position_id) 
		VALUES 	('Jack', 'Daniels', '01-01-1980', '12345', '100000', (SELECT id FROM position WHERE position_name = 'Director')),
				('Anna', 'Germanova', '03-03-1985', '888', '80000', (SELECT id FROM position WHERE position_name = 'Account')),
				('John', 'Travolta', '08-08-1970', '777', '200000', (SELECT id FROM position WHERE position_name = 'Cook')),
				('Lena', 'Ivanova', '10-10-1990', '555', '50000', (SELECT id FROM position WHERE position_name = 'Waiter'));


INSERT INTO ingredient (ingredient_name) VALUES ('Pork'), ('Beef'), ('Mutton'), ('Potatoes');

INSERT INTO stock (ingredient_id, qty) 
	VALUES 	((SELECT id FROM ingredient WHERE ingredient_name = 'Pork'), 100),
			((SELECT id FROM ingredient WHERE ingredient_name = 'Beef'), 100),
			((SELECT id FROM ingredient WHERE ingredient_name = 'Mutton'), 100),
			((SELECT id FROM ingredient WHERE ingredient_name = 'Potatoes'), 100);
 
INSERT INTO category_dish (category_name) VALUES ('Meat');

INSERT INTO dish (dish_name, category_id, price, weight) VALUES ('Steak', (SELECT id FROM category_dish WHERE category_name = 'Meat'), 100, 0.400);

INSERT INTO recipe (dish_id, ingredient_id, qty) VALUES ((SELECT id FROM dish WHERE dish_name = 'Steak'), (SELECT id FROM ingredient WHERE ingredient_name = 'Pork'), 0.600);

INSERT INTO menu (menu_name) VALUES ('Meat dishes'); 

INSERT INTO menu_detail (menu_id, dish_id) VALUES ((SELECT id FROM menu WHERE menu_name = 'Meat dishes'), (SELECT id FROM dish WHERE dish_name = 'Steak'));

INSERT INTO order_num (employee_id, table_num, date_order) VALUES ((SELECT id FROM employee WHERE name = 'Lena'), 1, LOCALTIMESTAMP);

INSERT INTO order_detail (order_id, dish_id, qty) VALUES ((SELECT id FROM order_num WHERE table_num = 1), (SELECT id FROM dish WHERE dish_name = 'Steak'), 1);

INSERT INTO prepared_dish (dish_id, employee_id, order_id, prepare_date) 
	VALUES 	((SELECT id FROM dish WHERE dish_name = 'Steak'), 
			(SELECT id FROM employee WHERE name = 'John'),
			(SELECT id FROM order_num WHERE table_num = 1),
			LOCALTIMESTAMP);