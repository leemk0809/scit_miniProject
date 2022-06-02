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
(brand_m_seq.nextval, '���γ�', '����', 'cor');

INSERT INTO brand_m
(brandnum, brandname, managername, email)
VALUES
(brand_m_seq.nextval, '�α��̳�', '�α�', 'min');

INSERT INTO brand_m
(brandnum, brandname, managername, email)
VALUES
(brand_m_seq.nextval, 'itt', '�ڴ�', 'mmm');

INSERT INTO brand_m
(brandnum, brandname, managername, email)
VALUES
(brand_m_seq.nextval, '�����', '����', 'gira');
