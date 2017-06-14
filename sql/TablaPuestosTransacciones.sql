-- Table: public.puestos_transacciones

-- DROP TABLE public.puestos_transacciones;

CREATE TABLE public.puestos_transacciones
(
  id integer NOT NULL DEFAULT nextval('puestos_transacciones_id_seq'::regclass),
  id_puesto integer,
  transacciones text
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.puestos_transacciones
  OWNER TO postgres;