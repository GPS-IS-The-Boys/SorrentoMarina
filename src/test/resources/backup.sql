create table if not exists ACCOUNTS (
    id integer not null auto_increment,
    email varchar(30) not null,
    password varchar(255) not null,
    roleId integer not null,
    primary key (id)
);

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
    password_ente varchar(32),
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
    foreign key (id_servizi) references SERVIZI(id) on update cascade on delete cascade,
    primary key (id)
);

create table if not exists RESPONSABILE_LIDO (
    id int not null auto_increment,
    nome varchar(32) not null,
    cognome varchar(32) not null,
    email varchar(32) not null,
    username varchar(32) not null,
    password_responsabile_lido varchar(32) not null,
    id_lido int not null,
    foreign key (id_lido) references LIDO(id) on update cascade on delete cascade,
    primary key (id)
);

create table if not exists PRENOTAZIONE (
    id int not null auto_increment,
    data_inizio date not null,
    data_fine date not null,
    num_posti int not null,
    costo float not null,
    id_lido int not null,
    id_turista int not null,
    foreign key (id_lido) references LIDO(id) on update cascade on delete cascade,
    foreign key (id_turista) references TURISTA(id) on update cascade on delete cascade,
    primary key (id)
);

create table if not exists ANNUNCIO (
    id int not null auto_increment,
    titolo varchar(32) not null,
    contenuto varchar(32) not null,
    foto varchar(64),
    id_lido int not null,
    foreign key (id_lido) references LIDO(id) on update cascade on delete cascade,
    primary key (id)
);

create table if not exists RECENSIONE (
    id int not null auto_increment,
    giudizio int not null check (giudizio between 1 AND 5),
    contenuto varchar(32),
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

insert into RESPONSABILE_ENTE(nome, cognome, email, username, password_ente) values ('Mario', 'Rossi', 'm.rossi@unisa.it', 'mrossi', 'rossimario');
insert into RESPONSABILE_ENTE(nome, cognome, email, username, password_ente) values ('Luigi', 'Bianchi', 'l.bianchi@unisa.it', 'lbianchi', 'bianchiluigi');

insert into RESPONSABILE_LIDO(nome, cognome, email, username, password_lido,id_lido) values ('Guido', 'Lavespa', 'guido.l@unisa.it', 'Gvespa', 'LavespaGuido',1);
insert into RESPONSABILE_LIDO(nome, cognome, email, username, password_lido,id_lido) values ('Antonio', 'Verdi', 'A-Verdi@unisa.it', 'A_Verdi', 'VerdiAntonio',7);


insert into ACCOUNTS (email, password, roleId) values ('diego@mail.it', 'qwerty', 1);
insert into ACCOUNTS (email, password, roleId) values ('dario@mail.it', 'qwerty', 2);

INSERT into TURISTA values(1,'Mario','Disco','marioDisco@gmail.com','userMario','passDisco');
INSERT into SERVIZI values(1,0,0,0,0,0,0,0);
INSERT into LIDO values(1,'LidoCinzia','Battibatti','330303603','cinzia@gmail.com','',12.5,4,5,1);
INSERT into PRENOTAZIONE values(1,'2020-06-12','2020-06-14',2,30,1,1);