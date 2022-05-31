DROP SEQUENCE product_m_seq;
DROP TABLE product_m;

CREATE TABLE product_m
	(
		brandnum    REFERENCES brand_m(brandnum),
		categorynum REFERENCES categories_m(categorynum),
		productnum  NUMBER PRIMARY KEY,
		productname VARCHAR2(100),
		price       NUMBER
	);
CREATE SEQUENCE product_m_seq;
