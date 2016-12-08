drop table  if exists users;
drop table  if exists mails;



create table users (id serial primary key, last_name varchar(255) not null,
						first_name varchar(255) not null,email varchar(255) not null,
						photo bytea, password varchar(255) not null);

create table mails (id serial primary key, object  varchar(255), content varchar(255),
	                  pj1 bytea, pj2 bytea, date timestamp without time zone, usersender_id int not NULL );

alter table mails add constraint FK_SENDER foreign key(usersender_id) references users(id);

-- creation de table intermediaire pour qu'un Mail peut avoir plusieurs dest--
create table mailToDest (mail_id int, id_receiver int);

alter table users add constraint email_unique unique(email);

