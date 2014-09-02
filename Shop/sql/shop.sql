/*创建商品表*/
create table store_product
(
   id bigint auto_increment primary key,
   name varchar(32) not null,
   description varchar(500),
   imageSrc varchar(500),
   price double not null
);

/*创建用户表*/
create table store_user
(
    id bigint auto_increment primary key,
    name varchar(32) unique not null,
    password  varchar(16) not null,
    address varchar(100),
    postCode varchar(10),
    email varchar(50),
    homePhone varchar(32),
    cellPhone varchar(32),
    officePhone varchar(32),
    type varchar(20),
    workNo varchar(20)
);
insert into store_user values(1,'throne212','123','成都市XXX街','621000','throne212@xxx.com','123456789','123456789','123456789','common',null);
insert into store_user values(2,'admin','123','','','admin@xxx.com','','','','admin','001');

/*创建订单表*/
create table store_order(
	id bigint  primary key,
	orderNum varchar(17) unique not null,
	status integer not null,
	user_id bigint references store_user(id),
	cost double(10,2)
);
/*创建订单项表*/
create table store_order_item(
	id bigint auto_increment primary key,
	amount integer not null,
	product_id bigint references store_product(id),
	order_id bigint references store_order(id)
);
