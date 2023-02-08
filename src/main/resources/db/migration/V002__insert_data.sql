
INSERT INTO `akash_coffeeshop`.`customers` 
(`id`, `customer_address`, `customer_contact`, `customer_name`, `zip_code`) 
VALUES 
('83a1aee2-a771-11ed-afa1-0242ac120002', 'Surat', '123456', 'Akash', '395001');

INSERT INTO `akash_coffeeshop`.`coffee_shops` 
(`id`, `shop_address`, `shop_name`, `zip_code`) 
VALUES 
('1e764b4a-a771-11ed-afa1-0242ac120002', 'Surat', 'Swiss Cafe', '395001'),
('2e764b4a-a771-11ed-afa1-0242ac120002', 'Ahmedabad', 'Chocolate Room Cafe', '295002');

INSERT INTO `akash_coffeeshop`.`menu_items` 
(`item_id`, `food_name`, `price`, `coffee_shop_id`) 
VALUES 
('ab4d8fec-a771-11ed-afa1-0242ac120002', 'Chocolate Coffee', '250.0', '1e764b4a-a771-11ed-afa1-0242ac120002'),
('ab4d8fec-a771-11ed-afa1-0242ac120003', 'Black Coffee', '350.0', '1e764b4a-a771-11ed-afa1-0242ac120002'),
('ab4d8fec-a771-11ed-afa1-0242ac120004', 'Plane Coffee', '200.0', '1e764b4a-a771-11ed-afa1-0242ac120002'),
('bb4d8fec-a771-11ed-afa1-0242ac120005', 'Latte', '400.0', '2e764b4a-a771-11ed-afa1-0242ac120002'),
('bb4d8fec-a771-11ed-afa1-0242ac120006', 'Espresso', '450.0', '2e764b4a-a771-11ed-afa1-0242ac120002');
