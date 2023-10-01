create table category
(
    id   bigint auto_increment
        primary key,
    name varchar(40) not null
)
    charset = utf8mb3;

create table book
(
    id          int auto_increment
        primary key,
    Title       varchar(100)  null,
    Author      varchar(100)  null,
    Description varchar(1000) null,
    Edition     varchar(100)  null,
    category_id bigint        null,
    ImageURL    varchar(254)  null,
    ISBN        mediumtext    null,
    Price       double        null,
    added_on    datetime      null,
    constraint book_id_uindex
        unique (id),
    constraint id
        unique (id),
    constraint id_2
        unique (id),
    constraint category_id_fk
        foreign key (category_id) references category (id)
);

create table checkout_cart
(
    id               bigint auto_increment
        primary key,
    product_id       bigint                             null,
    qty              int                                null,
    price            int                                null,
    order_date       datetime default CURRENT_TIMESTAMP null,
    user_id          int                                null,
    order_id         int                                null,
    payment_type     enum ('COD', 'ONLINE')             null,
    delivery_address text                               null
)
    charset = utf8mb3;

create table orders
(
    id       bigint auto_increment
        primary key,
    order_id varchar(40) null,
    book_id  int         null,
    qty      int         null,
    price    int         null,
    order_on date        null,
    status   int         null,
    constraint book_pk_id
        foreign key (book_id) references book (id)
)
    charset = utf8mb3;

create table roles
(
    id   int auto_increment
        primary key,
    name varchar(20) null
);

create table user
(
    id       bigint auto_increment
        primary key,
    username varchar(50)  null,
    password varchar(120) null,
    email    varchar(50)  null
);

create table user_roles
(
    user_id bigint null,
    role_id bigint null
);


