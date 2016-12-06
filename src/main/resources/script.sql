drop table  if exists users;
drop table  if exists mails;



create table users (id serial primary key, last_name varchar(255) not null,
						first_name varchar(255) not null,email varchar(255) not null,
						photo bytea, password varchar(255) not null);

create table mails (id serial primary key, objet  varchar(255), contenu varchar(255),
	                  PJ1 bytea, PJ2 bytea, date DATE, id_sender int not NULL );

alter table mails add constraint FK_SENDER foreign key(id_sender) references users(id);

-- creation de table intermediaire pour qu'un Mail peut avoir plusieurs dest--
create table mailToDest (mail_id int, id_receiver int);

