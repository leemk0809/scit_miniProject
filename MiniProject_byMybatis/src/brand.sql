DROP SEQUENCE brand_m_seq;
DROP TABLE brand_m;

CREATE TABLE brand_m
	(brandnum   NUMBER       PRIMARY KEY,
	brandname   VARCHAR2(50) NOT NULL,
	managername VARCHAR2(50) NOT NULL,
	email       VARCHAR2(50) NOT NULL
	);

CREATE SEQUENCE brand_m_seq;
