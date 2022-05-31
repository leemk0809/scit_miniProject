DROP SEQUENCE categories_m_seq;
DROP TABLE categories_m;

CREATE TABLE categories_m
	(
		categorynum  NUMBER PRIMARY KEY,
		categoryname VARCHAR2(50) NOT NULL
	);

CREATE SEQUENCE categories_m_seq;
