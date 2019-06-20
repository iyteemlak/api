
CREATE TABLE public.house (
    id bigint NOT NULL,
    contact character varying(255),
    description character varying(255),
    is_active boolean,
    lat double precision,
    lng double precision,
    price integer,
    rooms character varying(255)
);

-- ALTER TABLE public.house OWNER TO postgres;

CREATE SEQUENCE public.house_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- ALTER TABLE public.house_id_seq OWNER TO postgres;

ALTER SEQUENCE public.house_id_seq OWNED BY public.house.id;

ALTER TABLE ONLY public.house ALTER COLUMN id SET DEFAULT nextval('public.house_id_seq'::regclass);

ALTER TABLE ONLY public.house ADD CONSTRAINT house_pkey PRIMARY KEY (id);