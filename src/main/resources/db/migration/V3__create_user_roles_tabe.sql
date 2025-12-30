CREATE TABLE public.users_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,

    assigned_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    assigned_by VARCHAR(100),

    CONSTRAINT users_roles_pk PRIMARY KEY (user_id, role_id),

    CONSTRAINT fk_users_roles_user
        FOREIGN KEY (user_id)
        REFERENCES public.users (id)
        ON DELETE CASCADE,

    CONSTRAINT fk_users_roles_role
        FOREIGN KEY (role_id)
        REFERENCES public.roles (id)
        ON DELETE CASCADE
);

CREATE INDEX idx_users_roles_user_id
ON public.users_roles (user_id);

CREATE INDEX idx_users_roles_role_id
ON public.users_roles (role_id);
