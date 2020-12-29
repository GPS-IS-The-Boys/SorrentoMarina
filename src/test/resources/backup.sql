create table  if not exists accounts (
    id integer not null auto_increment,
    email varchar(30) not null,
    password varchar(255) not null,
    roleId integer not null,
    primary key (id)
);

create table  if not exists RESPONSABILE_ENTE (
    id int not null auto_increment,
    nome varchar(32) not null ,
    cognome varchar(32) not null,
    email varchar(32) not null,
    username varchar(32) not null,
    password_ente varchar(32) not null
);

create table if not exists SERVIZI (
    id int not null auto_increment,
    bar boolean not null,
    ristorante boolean not null,
    animazione boolean not null,
    wifi boolean not null,
    cabina boolean not null,
    beach_volley boolean not null,
    canoa boolean not null,
    primary key (id)
);

insert into RESPONSABILE_ENTE(nome, cognome, email, username, password_ente) values ('Mario', 'Rossi', 'm.rossi@unisa.it', 'mrossi', 'rossimario');
insert into RESPONSABILE_ENTE(nome, cognome, email, username, password_ente) values ('Luigi', 'Bianchi', 'l.bianchi@unisa.it', 'lbianchi', 'bianchiluigi');

insert into SERVIZI(id,bar,ristorante,animazione,wifi,cabina,beach_volley,canoa) values (1, true,false,true,false,true,false,true);
insert into SERVIZI(id,bar,ristorante,animazione,wifi,cabina,beach_volley,canoa) values (2, false,false,true,true,true,false,true);

insert into accounts (email, password, roleId) values ('diego@mail.it', 'qwerty', 1);
insert into accounts (email, password, roleId) values ('dario@mail.it', 'qwerty', 2);