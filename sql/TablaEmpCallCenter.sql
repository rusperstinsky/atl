-- Table: public.emp_call_center

-- DROP TABLE public.emp_call_center;

CREATE TABLE public.emp_call_center
(
  id integer NOT NULL DEFAULT nextval('emp_call_center_id_seq'::regclass),
  id_puesto integer,
  nombre text,
  pass text,
  id_emp integer,
  CONSTRAINT id_emp_call_center_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.emp_call_center
  OWNER TO postgres;
