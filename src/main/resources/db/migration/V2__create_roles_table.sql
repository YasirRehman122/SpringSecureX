CREATE TABLE public.roles (
	id bigint GENERATED ALWAYS AS IDENTITY NOT NULL,
	role_name varchar(50) NOT NULL,
	description varchar(150) NOT NULL,
	created_at timestamptz DEFAULT CURRENT_TIMESTAMP NOT NULL,
	created_by varchar(50) NOT NULL,
	modified_at timestamptz DEFAULT CURRENT_TIMESTAMP NOT NULL,
	modified_by varchar(50) NULL,
	is_active boolean DEFAULT true NOT NULL,
	CONSTRAINT roles_pk PRIMARY KEY (id),
	CONSTRAINT role_name_format CHECK (role_name LIKE 'ROLE_%'),
	CHECK (length(trim(role_name)) > 0)
);
CREATE INDEX idx_roles_name ON public.roles(role_name);
CREATE UNIQUE INDEX uq_roles_role_name_ci
ON public.roles (lower(role_name));

