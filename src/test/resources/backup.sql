create table accounts (
    id integer not null auto_increment,
    email varchar(30) not null,
    password varchar(255) not null,
    roleId integer not null,
    primary key (id)
);

create table responsabile_ente (
    id int not null auto_increment,
    nome varchar(32) not null ,
    cognome varchar(32) not null,
    email varchar(32) not null,
    username varchar(32) not null,
    password_ente varchar(32) not null
);

insert into responsabile_ente(nome, cognome, email, username, password_ente) values ('Mario', 'Rossi', 'm.rossi@unisa.it', 'mrossi', 'rossimario');
insert into responsabile_ente(nome, cognome, email, username, password_ente) values ('Luigi', 'Bianchi', 'l.bianchi@unisa.it', 'lbianchi', 'bianchiluigi');

insert into accounts (email, password, roleId) values ('diego@mail.it', 'qwerty', 1);
insert into accounts (email, password, roleId) values ('dario@mail.it', 'qwerty', 2);