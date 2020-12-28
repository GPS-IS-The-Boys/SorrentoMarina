create table RESPONSABILE_ENTE (
    id int not null auto_increment,
    nome varchar(32) not null ,
    cognome varchar(32) not null,
    email varchar(32) not null,
    username varchar(32) not null,
    password_ente varchar(32) not null
);

insert into RESPONSABILE_ENTE(nome, cognome, email, username, password_ente) values ('Mario', 'Rossi', 'm.rossi@unisa.it', 'mrossi', 'rossimario');
insert into RESPONSABILE_ENTE(nome, cognome, email, username, password_ente) values ('Luigi', 'Bianchi', 'l.bianchi@unisa.it', 'lbianchi', 'bianchiluigi');
