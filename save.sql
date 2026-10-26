CREATE TABLE save (
    id int NOT NULL PRIMARY KEY,
    nome character varying(100) NOT NULL,
    dia integer NOT NULL,
    dinheiro double precision NOT NULL,
    upgrades character varying(100)[]
);
