CREATE TABLE save (
    id SERIAL NOT NULL PRIMARY KEY,
    nome character varying(100) NOT NULL,
    dia integer NOT NULL,
    dinheiro double precision NOT NULL,
    noite boolean NOT NULL,
    upgrades character varying(100)[]
);
