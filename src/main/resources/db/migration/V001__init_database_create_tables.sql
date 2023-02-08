CREATE TABLE IF NOT EXISTS customers (
    id VARCHAR(255) NOT NULL,
    customer_address VARCHAR(255),
    customer_contact VARCHAR(255),
    customer_name VARCHAR(255),
    zip_code INTEGER,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS coffee_shops (
    id VARCHAR(255) NOT NULL,
    shop_address VARCHAR(255),
    shop_name VARCHAR(255),
    zip_code INTEGER,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS menu_items (
    item_id VARCHAR(255) NOT NULL,
    food_name VARCHAR(255),
    price DOUBLE PRECISION,
    coffee_shop_id VARCHAR(255),
    PRIMARY KEY (item_id),
    FOREIGN KEY (coffee_shop_id)
        REFERENCES coffee_shops (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS orders (
    order_id VARCHAR(255) NOT NULL,
    quantity INTEGER,
    total_price DOUBLE PRECISION,
    menu_item_item_id VARCHAR(255),
    PRIMARY KEY (order_id),
    FOREIGN KEY (menu_item_item_id)
        REFERENCES menu_items (item_id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS order_summary (
    id VARCHAR(255) NOT NULL,
    message VARCHAR(255),
    status VARCHAR(255),
    customer_id VARCHAR(255),
    order_order_id VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id)
        REFERENCES customers (id),
    FOREIGN KEY (order_order_id)
        REFERENCES orders (order_id)
)  ENGINE=INNODB;
