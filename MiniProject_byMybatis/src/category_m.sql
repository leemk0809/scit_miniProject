DROP SEQUENCE categories_m_seq;
DROP TABLE categories_m;

CREATE TABLE categories_m
	(
		categorynum  NUMBER PRIMARY KEY,
		categoryname VARCHAR2(50) NOT NULL
	);

CREATE SEQUENCE categories_m_seq;


---Insert
INSERT INTO categories_m
(categorynum, categoryname)
VALUES
(categories_m_seq.nextval, '�к긯');

INSERT INTO categories_m
(categorynum, categoryname)
VALUES
(categories_m_seq.nextval, '����');

UPDATE categories_m
SET categoryname = 'ħ��'
WHERE categorynum = 1;

DELETE FROM categories_m
WHERE categorynum = 1;
