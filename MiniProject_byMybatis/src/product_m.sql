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


--insert
INSERT INTO product_m
(brandnum, categorynum, productnum, productname, price)
VALUES
(4, 2, product_m_seq.nextval, 'Àè½¼Ä«¸á·¹¿Â', 350000);