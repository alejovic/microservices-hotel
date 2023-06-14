-- public.micro_users definition
-- Drop table
DROP TABLE if exists public.user;
CREATE TABLE public.user
(
    id    int8 NOT NULL,
    about varchar(100) NULL,
    email varchar(255) NULL,
    name  varchar(20) NULL,
    CONSTRAINT msh_user_pkey PRIMARY KEY (id)
);
