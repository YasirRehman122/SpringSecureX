CREATE TABLE public.users (
	id bigint GENERATED ALWAYS AS IDENTITY NOT NULL,
	first_name varchar(100) NOT NULL,
	middle_name varchar(100) NULL,
	last_name varchar(100) NOT NULL,
	password_hash varchar(255) NOT NULL,
	created_at timestamptz DEFAULT CURRENT_TIMESTAMP NOT NULL,
	created_by varchar(100) NOT NULL,
	modified_at timestamptz DEFAULT CURRENT_TIMESTAMP NOT NULL,
	modified_by varchar(100) NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
);
