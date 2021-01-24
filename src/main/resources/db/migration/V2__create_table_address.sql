CREATE sequence sq_address_addr;

create table tb_address_addr(
	id_address int8 NOT NULL,
	id_client int8 NOT NULL,
	st_street varchar(100) NOT NULL,
	st_complement varchar(10) NULL,
	st_neighbordhood varchar(50) NOT NULL,
	st_city varchar(30) NOT NULL,
	st_state varchar(30) NOT NULL,
	st_country varchar(30) NOT NULL,
	dt_created_date timestamp NOT NULL,
	dt_modified_date timestamp NULL,
	CONSTRAINT tb_address_pkey PRIMARY KEY (id_address)
);