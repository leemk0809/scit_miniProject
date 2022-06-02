DROP SEQUENCE brand_m_seq;
DROP TABLE brand_m;

CREATE TABLE brand_m
	(
	brandnum    NUMBER       PRIMARY KEY,
	brandname   VARCHAR2(50) NOT NULL,
	managername VARCHAR2(50) NOT NULL,
	email       VARCHAR2(50) NOT NULL
	);

CREATE SEQUENCE brand_m_seq;


---Insert
INSERT INTO brand_m
(brandnum, brandname, managername, email)
VALUES
(brand_m_seq.nextval, '¸¸µÎ³×', '¸¸µÎ', 'cor');

INSERT INTO brand_m
(brandnum, brandname, managername, email)
VALUES
(brand_m_seq.nextval, '¹Î±¹ÀÌ³×', '¹Î±¹', 'min');

DELETE FROM brand_m
WHERE brandnum = 1;

UPDATE brand_m
SET brandname = '¹Î±¹ÀÌ³× ²ÉÁý'
WHERE brandnum = 2;
