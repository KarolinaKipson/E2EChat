create table "role" (
	id_role bigserial not null,
	name varchar(255),
	primary key(id_role)
);

create table "user" (
	id_user bigserial not null,
	user_name varchar(255) not null,
	user_password varchar(80) not null,
	primary key(id_user)
);

create table "user_roles" (
	user_id bigint not null,
	role_id bigint not null,
	primary key(user_id, role_id),
	constraint fk_user_user_role
	foreign key(user_id)
	references "user" (id_user)
	on delete cascade,
	constraint fk_role_user_roles
	foreign key(role_id)
	references "role" (id_role)
	on delete cascade
);

/* TODO: Ovdje se mogu dodati još user_reciver, za sada nisam dodavao */
create table "message" (
    id_message bigserial not null,
    content varchar(1024) not null,
    sending_date timestamp not null,
    user_id bigint not null,
    primary key(id_message),
    constraint fk_user_sender_message
	foreign key(user_id)
	references "user"(id_user)
	on delete cascade
);