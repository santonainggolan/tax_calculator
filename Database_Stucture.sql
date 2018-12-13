/** Database Stucture
	Database : PostgreSQL
	Database name : postgres
			host name /adress : 127.0.0.1 / localhost
			port      : 5432
			username  : postgres
			password  : password
			schema	  : shopee
			 table name : tax_amount
			  table columns : 
			  			- id(integer)
			  			- name (text)
			  			- code (char)
			  			- price (double precision)
**/



-- script to generate schema

-- DROP SCHEMA shopee ;

CREATE SCHEMA shopee
    AUTHORIZATION postgres;


-- script to generate table

-- DROP TABLE shopee.tax_amount;

CREATE TABLE shopee.tax_amount
(
    id integer NOT NULL,
    name text COLLATE pg_catalog."default",
    code "char",
    price double precision,
    CONSTRAINT tax_amount_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE shopee.tax_amount
    OWNER to postgres;