# spring_boot_mybatis
SpringBoot with mybatis


CREATE TABLE IF NOT EXISTS public.statistic
(
    id bigint NOT NULL DEFAULT nextval('statistic_id_seq'::regclass),
    max double precision NOT NULL,
    mean double precision NOT NULL,
    median double precision NOT NULL,
    min double precision NOT NULL,
    CONSTRAINT statistic_pkey PRIMARY KEY (id)
)

