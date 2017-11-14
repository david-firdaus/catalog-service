-- Table: public.travel_package
CREATE TABLE IF NOT EXISTS public.travel_package
(
  id bigint NOT NULL,
  entity_key character varying(255),
  version bigint,
  estimate_price numeric(19,2),
  name character varying(255) NOT NULL,
  status integer NOT NULL,
  term_and_condition character varying(255),
  type integer NOT NULL,
  CONSTRAINT travel_package_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.travel_package
  OWNER TO postgres;

-- Table: public.itinerary_detail
CREATE TABLE IF NOT EXISTS public.itinerary_detail
(
  id bigint NOT NULL,
  entity_key character varying(255),
  version bigint,
  destination_id bigint NOT NULL,
  travel_package_id bigint NOT NULL,
  CONSTRAINT itinerary_detail_pkey PRIMARY KEY (id),
  CONSTRAINT fk5icnlur6fj8xum42hwtj36kdf FOREIGN KEY (destination_id)
  REFERENCES public.destination (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkqoqtm9q95scs4jggoefy38c68 FOREIGN KEY (travel_package_id)
  REFERENCES public.travel_package (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.itinerary_detail
  OWNER TO postgres;


-- Table: public.price_detail
CREATE TABLE IF NOT EXISTS  public.price_detail
(
  id bigint NOT NULL,
  entity_key character varying(255),
  version bigint,
  days integer NOT NULL,
  departure_date timestamp without time zone NOT NULL,
  nights integer NOT NULL,
  note character varying(255),
  price numeric(19,2) NOT NULL,
  travel_package_id bigint NOT NULL,
  CONSTRAINT price_detail_pkey PRIMARY KEY (id),
  CONSTRAINT fk4w9obp94870r193yhdfq5ni79 FOREIGN KEY (travel_package_id)
  REFERENCES public.travel_package (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT price_detail_days_check CHECK (days >= 1),
  CONSTRAINT price_detail_nights_check CHECK (nights >= 1),
  CONSTRAINT price_detail_price_check CHECK (price >= 100::numeric)
)
WITH (
OIDS=FALSE
);
ALTER TABLE public.price_detail
  OWNER TO postgres;

