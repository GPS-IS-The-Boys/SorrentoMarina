create table if not exists TURISTA (
    id int not null auto_increment,
    nome varchar(32) not null,
    cognome varchar(32) not null,
    email varchar(32) not null,
    username varchar(32),
    password_turista varchar(64),
    primary key (id)
);

create table if not exists RESPONSABILE_ENTE (
    id int not null auto_increment,
    nome varchar(32) not null,
    cognome varchar(32) not null,
    email varchar(32) not null,
    username varchar(32),
    password_ente varchar(64),
    primary key (id)
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

create table if not exists LIDO (
    id int not null auto_increment,
    nome varchar(32) not null,
    indirizzo varchar(32) not null,
    telefono varchar(32) not null,
    email varchar(32) not null,
    logo varchar(64),
    prezzo_singolo float not null,
    num_righe int not null,
    num_colonne int not null,
    id_servizi int not null,
    id_resp_ente int,
    foreign key (id_resp_ente) references RESPONSABILE_ENTE(id) on update cascade,
    foreign key (id_servizi) references SERVIZI(id) on update cascade on delete cascade,
    primary key (id)
);

create table if not exists RESPONSABILE_LIDO (
    id int not null auto_increment,
    nome varchar(32) not null,
    cognome varchar(32) not null,
    email varchar(32) not null,
    username varchar(32) not null,
    password_responsabile_lido varchar(64) not null,
    id_lido int not null,
    id_resp_ente int,
    foreign key (id_resp_ente) references RESPONSABILE_ENTE(id) on update cascade,
    foreign key (id_lido) references LIDO(id) on update cascade on delete cascade,
    primary key (id)
);

create table if not exists PRENOTAZIONE (
    id int not null auto_increment,
    data_inizio date not null,
    data_fine date not null,
    num_posti int not null,
    costo float not null,
    codice varchar(32) not null,
    id_lido int not null,
    id_turista int not null,
    foreign key (id_lido) references LIDO(id) on update cascade on delete cascade,
    foreign key (id_turista) references TURISTA(id) on update cascade on delete cascade,
    primary key (id)
);

create table if not exists ANNUNCIO (
    id int not null auto_increment,
    titolo varchar(32) not null,
    contenuto varchar(64) not null,
    foto varchar(64),
    id_lido int not null,
    foreign key (id_lido) references LIDO(id) on update cascade on delete cascade,
    primary key (id)
);

create table if not exists RECENSIONE (
    id int not null auto_increment,
    giudizio int not null check (giudizio between 1 AND 5),
    contenuto varchar(64),
    id_lido int not null,
    id_turista int not null,
    primary key (id),
    foreign key (id_lido) references LIDO(id) on update cascade on delete cascade,
    foreign key (id_turista) references TURISTA(id) on update cascade on delete cascade
);
create table if not exists OMBRELLONE (
    id int not null auto_increment,
    num_riga int not null,
    num_colonna int not null,
    id_prenotazione int not null,
    primary key (id),
    foreign key (id_prenotazione) references PRENOTAZIONE(id) on update cascade on delete cascade
);

insert into SERVIZI(bar,ristorante,animazione,wifi,cabina,beach_volley,canoa) values (true,false,true,false,true,false,true);
insert into SERVIZI(bar,ristorante,animazione,wifi,cabina,beach_volley,canoa) values (false,false,true,true,true,false,true);
insert into SERVIZI(bar,ristorante,animazione,wifi,cabina,beach_volley,canoa) values (false,true,true,true,true,false,true);
insert into SERVIZI(bar,ristorante,animazione,wifi,cabina,beach_volley,canoa) values (true,false,false,true,false,false,true);
insert into RESPONSABILE_ENTE(nome, cognome, email, username, password_ente) values ('Nome1', 'Cognome1', 'Email1', 'Username1', 'e38ad214943daad1d64c102faec29de4afe9da3d');
insert into RESPONSABILE_ENTE(nome, cognome, email, username, password_ente) values ('Nome2', 'Cognome2', 'Email2', 'Username2', '2aa60a8ff7fcd473d321e0146afd9e26df395147');
insert into RESPONSABILE_ENTE(nome, cognome, email, username, password_ente) values ('Nome3', 'Cognome3', 'Email3', 'Username3', '1119cfd37ee247357e034a08d844eea25f6fd20f');
insert into RESPONSABILE_ENTE(nome, cognome, email, username, password_ente) values ('Nome4', 'Cognome4', 'Email4', 'Username4', 'a1d7584daaca4738d499ad7082886b01117275d8');
INSERT into LIDO (nome, indirizzo, telefono, email, logo,prezzo_singolo,num_righe,num_colonne,id_servizi,id_resp_ente) values('Nome1','Indirizzo1','Telefono1','email1','logo1',12.5,4,5,1,1);
INSERT into LIDO (nome, indirizzo, telefono, email, logo,prezzo_singolo,num_righe,num_colonne,id_servizi,id_resp_ente) values('Nome2','Indirizzo2','Telefono2','email2','logo2',12.5,4,5,2,1);
INSERT into LIDO (nome, indirizzo, telefono, email, logo,prezzo_singolo,num_righe,num_colonne,id_servizi,id_resp_ente) values('Nome3','Indirizzo3','Telefono3','email3','logo3',12.5,4,5,3,1);
INSERT into LIDO (nome, indirizzo, telefono, email, logo,prezzo_singolo,num_righe,num_colonne,id_servizi,id_resp_ente) values('Nome4','Indirizzo4','Telefono4','email4','logo4',12.5,4,5,4,1);
insert into RESPONSABILE_LIDO(nome, cognome, email, username, password_responsabile_lido, id_lido, id_resp_ente) values ('Nome1', 'Cognome1', 'Email1', 'Username1', 'e38ad214943daad1d64c102faec29de4afe9da3d',1,1);
insert into RESPONSABILE_LIDO(nome, cognome, email, username, password_responsabile_lido, id_lido, id_resp_ente) values ('Nome2', 'Cognome2', 'Email2', 'Username2', '2aa60a8ff7fcd473d321e0146afd9e26df395147',2,1);
insert into RESPONSABILE_LIDO(nome, cognome, email, username, password_responsabile_lido, id_lido, id_resp_ente) values ('Nome3', 'Cognome3', 'Email3', 'Username3', '1119cfd37ee247357e034a08d844eea25f6fd20f',3,1);
insert into RESPONSABILE_LIDO(nome, cognome, email, username, password_responsabile_lido, id_lido, id_resp_ente) values ('Nome4', 'Cognome4', 'Email4', 'Username4', 'a1d7584daaca4738d499ad7082886b01117275d8',4,1);
INSERT into TURISTA(nome, cognome, email, username, password_turista) values ('Nome1', 'Cognome1', 'Email1', 'Username1', 'e38ad214943daad1d64c102faec29de4afe9da3d');
INSERT into TURISTA(nome, cognome, email, username, password_turista) values ('Nome2', 'Cognome2', 'Email2', 'Username2', '2aa60a8ff7fcd473d321e0146afd9e26df395147');
INSERT into TURISTA(nome, cognome, email, username, password_turista) values ('Nome3', 'Cognome3', 'Email3', 'Username3', '1119cfd37ee247357e034a08d844eea25f6fd20f');
INSERT into TURISTA(nome, cognome, email, username, password_turista) values ('Nome3', 'Cognome4', 'Email4', 'Username4', 'a1d7584daaca4738d499ad7082886b01117275d8');
INSERT into PRENOTAZIONE(data_inizio, data_fine, num_posti, costo, codice, id_lido, id_turista) values('2020-06-09','2020-06-09',2,30,'AA1234',1,1);
INSERT into PRENOTAZIONE(data_inizio, data_fine, num_posti, costo, codice, id_lido, id_turista) values('2020-07-09','2020-07-09',2,30,'BB1234',2,2);
INSERT into PRENOTAZIONE(data_inizio, data_fine, num_posti, costo, codice, id_lido, id_turista) values('2020-08-09','2020-08-09',2,30,'CC1234',3,3);
INSERT into PRENOTAZIONE(data_inizio, data_fine, num_posti, costo, codice, id_lido, id_turista) values('2020-09-09','2020-09-09',2,30,'DD1234',4,4);
insert into ANNUNCIO(titolo, contenuto, foto, id_lido) values
( 'Riapertura','Grande riapertura ','C:\\Users\\User\\Desktop\\Uni\\IS\\foto1.jpg',1),
( 'Sconti','Sconti la prossima settimana','C:\\Users\\User\\Desktop\\Uni\\IS\\foto2.jpg',1 ),
( 'Chiusura','Chiusura per il fine settimana','C:\\Users\\User\\Desktop\\Uni\\IS\\foto3.jpg',2),
( 'Riapertura','Riapertura il giorno 10 Maggio','C:\\Users\\User\\Desktop\\Uni\\IS\\foto4.jpg',3);
insert into RECENSIONE(giudizio, contenuto, id_lido, id_turista) values
(3,'Struttura sufficiente',1,1),
(4,'Struttura molto attrezzata',1,2),
(2,'Ristorante deludente',2,1),
(5,'Eccezzionale',3,3),
(4,'Ottimo paesaggio',4,4);
INSERT into OMBRELLONE(num_riga, num_colonna, id_prenotazione) values ( 2,3,1 );
INSERT into OMBRELLONE(num_riga, num_colonna, id_prenotazione) values ( 1,1,2 );
INSERT into OMBRELLONE(num_riga, num_colonna, id_prenotazione) values ( 4,7,3 );
INSERT into OMBRELLONE(num_riga, num_colonna, id_prenotazione) values ( 5,5,4 );