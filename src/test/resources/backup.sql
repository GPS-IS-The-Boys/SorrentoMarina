create table accounts
(
    id       integer      not null auto_increment,
    email    varchar(30)  not null,
    password varchar(255) not null,
    roleId   integer      not null,
    primary key (id)
);

insert into accounts (email, password, roleId)
values ('diego@mail.it', 'qwerty', 1);
insert into accounts (email, password, roleId)
values ('dario@mail.it', 'qwerty', 2);