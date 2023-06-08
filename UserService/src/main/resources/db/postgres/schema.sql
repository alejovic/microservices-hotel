-- public.micro_users definition
-- Drop table
DROP TABLE if exists public.micro_users;
CREATE TABLE public.micro_users
(
    id    int8 NOT NULL,
    about varchar(100) NULL,
    email varchar(255) NULL,
    name  varchar(20) NULL,
    CONSTRAINT micro_users_pkey PRIMARY KEY (id)
);
