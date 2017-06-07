-- Table: public.tablas_edit

-- DROP TABLE public.tablas_edit;

CREATE TABLE public.tablas_edit
(
  id integer NOT NULL DEFAULT nextval('tablas_edit_id_seq'::regclass),
  tabla text
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.tablas_edit
  OWNER TO postgres;