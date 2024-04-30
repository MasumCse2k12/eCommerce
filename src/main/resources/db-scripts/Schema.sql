
CREATE TABLE if not exists customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) not null,
    email VARCHAR(100),
    contact VARCHAR(20) not null,
    row_status VARCHAR(10) not null,
    version bigint not null,
    created timestamp,
    updated timestamp
);

CREATE TABLE if not exists product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    price DECIMAL(10,2),
    description TEXT,
    row_status VARCHAR(10) not null,
    version bigint not null,
    created timestamp,
    updated timestamp
);


CREATE TABLE if not exists e_order (
    id SERIAL PRIMARY KEY,
    customer_id integer not null
        constraint order_fk_customer_id
        references customer,
    order_date timestamp,
    row_status VARCHAR(10) not null,
    version bigint not null,
    created timestamp,
    updated timestamp
);

CREATE TABLE if not exists order_item (
    id SERIAL PRIMARY KEY,
    order_id integer not null
        constraint order_item_fk_order_id
        references e_order,
    product_id integer not null
        constraint order_item_fk_product_id
        references product,
    quantity smallint,
    row_status VARCHAR(10) not null,
    version bigint not null,
    created timestamp,
    updated timestamp
);


CREATE TABLE if not exists sales (
    id SERIAL PRIMARY KEY,
    product_id integer not null
        constraint sales_fk_product_id
        references product,
    sale_date timestamp,
    amount DECIMAL(10,2),
    row_status VARCHAR(10) not null,
    version bigint not null,
    created timestamp,
    updated timestamp
);


ALTER TABLE order_item alter column quantity type integer;