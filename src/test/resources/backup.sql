drop table if exists RESPONSABILE_ENTE,ANNUNCIO,RECENSIONE;

create table RESPONSABILE_ENTE (
    id int not null auto_increment,
    nome varchar(32) not null ,
    cognome varchar(32) not null,
    email varchar(32) not null,
    username varchar(32) not null,
    password_ente varchar(32) not null
);

create table ANNUNCIO(
    id int not null auto_increment,
    titolo varchar(32) not null,
    contenuto varchar(256) not null,
    foto varchar(64) not null,
    id_lido int not null
);

create table RECENSIONE(
    id int not null auto_increment,
    giudizio int not null,
    contenuto varchar(256),
    id_lido int not null,
    id_turista int not null
);

/*insert into RESPONSABILE_ENTE(nome, cognome, email, username, password_ente) values ('Mario', 'Rossi', 'm.rossi@unisa.it', 'mrossi', 'rossimario');
insert into RESPONSABILE_ENTE(nome, cognome, email, username, password_ente) values ('Luigi', 'Bianchi', 'l.bianchi@unisa.it', 'lbianchi', 'bianchiluigi');*/

insert into ANNUNCIO(titolo, contenuto, foto, id_lido) values
    ( 'Riapertura','Grande riapertura il giorno 9 Giugno','C:\\Users\\User\\Desktop\\Uni\\IS\\foto1.jpg',1),
    ( 'Sconti','Sconti la prossima settimana','C:\\Users\\User\\Desktop\\Uni\\IS\\foto2.jpg',1 ),
    ( 'Chiusura','Chiusura per il fine settimana','C:\\Users\\User\\Desktop\\Uni\\IS\\foto3.jpg',2),
    ( 'Riapertura','Riapertura il giorno 10 Maggio','C:\\Users\\User\\Desktop\\Uni\\IS\\foto4.jpg',3);

insert into RECENSIONE(giudizio, contenuto, id_lido, id_turista) values
    (3,'Struttura sufficiente',1,1),
    (4,'Struttura molto attrezzata',1,2),
    (2,'Ristorante deludente',2,1),
    (5,'Eccezzionale',3,3),
    (4,'Ottimo paesaggio',4,4);