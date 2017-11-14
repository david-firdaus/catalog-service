CREATE TABLE hibernate_sequences
(
  sequence_name character varying(255) NOT NULL,
  next_val bigint,
  CONSTRAINT hibernate_sequences_pkey PRIMARY KEY (sequence_name)
)
WITH (
  OIDS=FALSE
);