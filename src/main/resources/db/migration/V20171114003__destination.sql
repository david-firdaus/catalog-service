CREATE TABLE IF NOT EXISTS destination
(
  id BIGINT PRIMARY KEY NOT NULL,
  entity_key VARCHAR(100) NOT NULL,
  version BIGINT  NOT NULL,
  name VARCHAR(100) NOT NULL,
  city VARCHAR(100),
  province VARCHAR(100),
  country VARCHAR(100),
  note VARCHAR(200)
);
CREATE INDEX destination_id_index ON public.destination (id);
CREATE UNIQUE INDEX destination_entityKey_uindex ON public.destination (entity_key);