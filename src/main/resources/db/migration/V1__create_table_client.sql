CREATE sequence sq_client_clie;

create table tb_client_clie(
	id_client int8 NOT NULL,
	st_name varchar(100) NOT NULL,
	st_identification varchar(11) NOT NULL,
	dt_created_date timestamp NOT NULL,
	dt_modified_date timestamp NULL,
	CONSTRAINT tb_client_pkey PRIMARY KEY (id_client)
);