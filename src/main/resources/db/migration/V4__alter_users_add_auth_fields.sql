ALTER TABLE public.users
ADD COLUMN username VARCHAR(100) NOT NULL,
ADD COLUMN email VARCHAR(100) NOT NULL,
ADD COLUMN is_active BOOLEAN DEFAULT TRUE NOT NULL;

CREATE INDEX idx_users_username ON public.users(username);
CREATE INDEX idx_users_email ON public.users(email);

CREATE UNIQUE INDEX uq_users_username_ci ON public.users(lower(username));
CREATE UNIQUE INDEX uq_users_email_ci ON public.users(lower(email));