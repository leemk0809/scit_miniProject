DROP SEQUENCE product_m_seq;
DROP TABLE product_m;

CREATE TABLE product_m
	(
		brandnum    REFERENCES brand_m(brandnum) ON DELETE CASCADE,
		categorynum REFERENCES categories_m(categorynum) ON DELETE CASCADE,
		productnum  NUMBER PRIMARY KEY,
		productname VARCHAR2(100),
		price       NUMBER
	);
CREATE SEQUENCE product_m_seq;
