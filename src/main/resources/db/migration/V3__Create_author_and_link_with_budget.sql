create table author
(
    id     serial primary key,
    фио    text  not null
);

alter table budget
    add column author_id int null;
alter table budget
    add constraint fk_budget_on_author foreign key (author_id) references author(id);