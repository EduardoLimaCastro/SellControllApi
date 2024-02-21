CREATE TABLE orders_buy (
    id bigint NOT NULL auto_increment,
    supplier_id bigint not null,
    item varchar(255) not null,
    quantity int not null,
    price double not null,
    total_price double not null,
    date datetime not null,

    primary key(id),
    constraint fk_orders_buy_supplier_id foreign key(supplier_id) references suppliers(id)
);