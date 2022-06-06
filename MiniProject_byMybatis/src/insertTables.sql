DROP SEQUENCE inventory_m_seq;
DROP TABLE inventory_m;
CREATE TABLE inventory_m
(
    seq NUMBER PRIMARY KEY,
    productnum REFERENCES product_m(productnum),
    stock NUMBER DEFAULT 0
);
CREATE SEQUENCE inventory_m_seq;

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

DROP SEQUENCE categories_m_seq;
DROP TABLE categories_m;
CREATE TABLE categories_m
	(
		categorynum  NUMBER PRIMARY KEY,
		categoryname VARCHAR2(50) NOT NULL
	);
CREATE SEQUENCE categories_m_seq;




INSERT INTO categories_m (categorynum, categoryname) VALUES (categories_m_seq.nextval, '����');
INSERT INTO categories_m (categorynum, categoryname) VALUES (categories_m_seq.nextval, '�к긯');

INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '�轼ī�᷹��', '�轼', 'jason@kamel.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '��ε�', '���', 'roddi@kamel.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '����ũ���̺�', '����', 'leaktable@leak.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '������', '������', 'munito@gmail.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '�����ڽ�', '����', 'twotwo@gmail.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '�ؽ���', '��', 'texture31@naver.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '�ƿ�Ʈ��', '��', 'outtro@naver.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '�ڸ�', '�ڸ�', 'kore@gmail.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '�ｺƮȣ����', '�ｺ��', 'hoite@gmail.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '���̺���', '������', 'joybrown@naver.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '����', '�����', 'bimble@naver.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '��״�����', '��ħ', 'morningnon@gmail.com');

INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (1, 1, product_m_seq.nextval, 'Round B Lounge Chair', 396000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (1, 1, product_m_seq.nextval, 'Round B Dining Chair', 330000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (2, 1, product_m_seq.nextval, 'ARC Bench Oval', 450000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (2, 1, product_m_seq.nextval, 'ARC Stool Oval', 230000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (3, 1, product_m_seq.nextval, 'My Kinda Stool', 320000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (3, 1, product_m_seq.nextval, '����� ���丸', 300000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (3, 1, product_m_seq.nextval, '���� ����� ü��', 960000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (3, 1, product_m_seq.nextval, 'Ʈ���� ����� ü��', 760000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (4, 1, product_m_seq.nextval, 'CALM CHAIR', 340000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (4, 1, product_m_seq.nextval, 'BOW CHAIR / IVORY BACK', 260000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (5, 1, product_m_seq.nextval, '��ũ ��ġ', 280000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (5, 1, product_m_seq.nextval, '���� ��ġ', 170000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (6, 1, product_m_seq.nextval, 'ST1', 190000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (6, 1, product_m_seq.nextval, 'LCH2', 660000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (6, 1, product_m_seq.nextval, 'LCH1', 510000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (6, 1, product_m_seq.nextval, 'CH3', 280000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (6, 1, product_m_seq.nextval, 'CH2', 330000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (6, 1, product_m_seq.nextval, 'CH1', 330000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (7, 1, product_m_seq.nextval, 'Arm Chair', 550000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (7, 1, product_m_seq.nextval, 'Danish Cord Chair', 680000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (7, 1, product_m_seq.nextval, 'Bench', 726000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (7, 1, product_m_seq.nextval, 'Stool', 380000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '���� �ټ� Ȩ���� ������ ��Ʈ', 109000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '��� ��ư Ȩ���� ������ ��Ʈ', 99000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '��е� 60�� ��� �����̺�', 139000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '��е� 60�� ���� Ŀ��', 20000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '���� 30�� ħ�� ��Ʈ', 16000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '���� 16�� ħ�� ��Ʈ', 16000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '���� Ȩ���� ���ǽ�', 59000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '���� Ȩ���� ������ ��Ʈ', 88000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (9, 2, product_m_seq.nextval, 'Plant Dyeing Cotton Fabric Blind Solid', 138000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (9, 2, product_m_seq.nextval, 'Plant Dyeing Cotton Fabric Blind Line', 138000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (9, 2, product_m_seq.nextval, 'Plant Dyeing ASA Handkerchief', 20000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (9, 2, product_m_seq.nextval, 'Be The Nature Fabric Half', 198000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (9, 2, product_m_seq.nextval, 'Be The Nature Fabric Solid', 198000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (10, 2, product_m_seq.nextval, 'Garden of Paris', 32000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (10, 2, product_m_seq.nextval, 'Newyork #2', 36000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (10, 2, product_m_seq.nextval, 'Stay', 32000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (11, 2, product_m_seq.nextval, '��� ��Ŷ - ����(ORUM)', 259000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (11, 2, product_m_seq.nextval, '��Ƽ ��ġŸ�� M - ��Ŭ����(eclipse)', 44000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (11, 2, product_m_seq.nextval, '��Ƽ ��ġŸ�� L - �̽���(isla)', 55000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (12, 2, product_m_seq.nextval, 'Check Daisy', 232000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (12, 2, product_m_seq.nextval, 'Blue Vase', 232000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (12, 2, product_m_seq.nextval, 'Popcorn Flower', 232000);

INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 1, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 2, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 3, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 4, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 5, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 6, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 7, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 8, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 9, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 10, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 11, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 12, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 13, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 14, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 15, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 16, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 17, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 18, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 19, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 20, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 21, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 22, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 23, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 24, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 25, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 26, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 27, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 28, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 29, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 30, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 31, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 32, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 33, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 34, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 35, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 36, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 37, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 38, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 39, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 40, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 41, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 42, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 43, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 44, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 45, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 46, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 47, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 48, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 49, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 50, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 51, 1);
INSERT INTO inventory_m (seq, productnum, stock) VALUES (inventory_m_seq.nextval, 52, 1);