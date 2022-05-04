create table expense(
    id bigint primary key auto_increment,
    description varchar(100),
    date date,
    value decimal(10,2),
    category varchar(100)
);

