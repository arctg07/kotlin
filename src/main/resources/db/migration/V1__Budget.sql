create table budget
(
    id     serial primary key,
    year   int  not null,
    month  int  not null,
    amount int  not null,
    type   text not null
);

insert into budget (year, month, amount, type) values (2019, 1, 100, 'Комиссия');