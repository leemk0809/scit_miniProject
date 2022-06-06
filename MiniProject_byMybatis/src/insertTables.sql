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




INSERT INTO categories_m (categorynum, categoryname) VALUES (categories_m_seq.nextval, '가구');
INSERT INTO categories_m (categorynum, categoryname) VALUES (categories_m_seq.nextval, '패브릭');

INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '잭슨카멜레온', '잭슨', 'jason@kamel.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '브로디', '브로', 'roddi@kamel.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '오블리크테이블', '오블리', 'leaktable@leak.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '무니토', '무니토', 'munito@gmail.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '투투박스', '투투', 'twotwo@gmail.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '텍스쳐', '텍', 'texture31@naver.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '아우트로', '형', 'outtro@naver.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '코르', '코르', 'kore@gmail.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '쿤스트호이테', '쿤스레', 'hoite@gmail.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '조이브라운', '조이쿤', 'joybrown@naver.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '빔블', '범블비', 'bimble@naver.com');
INSERT INTO brand_m (brandnum, brandname, managername, email) VALUES (brand_m_seq.nextval, '모닝눈나잇', '아침', 'morningnon@gmail.com');

INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (1, 1, product_m_seq.nextval, 'Round B Lounge Chair', 396000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (1, 1, product_m_seq.nextval, 'Round B Dining Chair', 330000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (2, 1, product_m_seq.nextval, 'ARC Bench Oval', 450000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (2, 1, product_m_seq.nextval, 'ARC Stool Oval', 230000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (3, 1, product_m_seq.nextval, 'My Kinda Stool', 320000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (3, 1, product_m_seq.nextval, '라운지 오토만', 300000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (3, 1, product_m_seq.nextval, '스템 라운지 체어', 960000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (3, 1, product_m_seq.nextval, '트위그 라운지 체어', 760000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (4, 1, product_m_seq.nextval, 'CALM CHAIR', 340000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (4, 1, product_m_seq.nextval, 'BOW CHAIR / IVORY BACK', 260000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (5, 1, product_m_seq.nextval, '파크 벤치', 280000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (5, 1, product_m_seq.nextval, '웰컴 벤치', 170000);
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
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '린넨 텐셀 홈웨어 상하의 세트', 109000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '모달 코튼 홈웨어 상하의 세트', 99000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '고밀도 60수 양면 차렵이불', 139000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '고밀도 60수 베개 커버', 20000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '광목 30수 침구 세트', 16000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '광목 16수 침구 세트', 16000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '순면 홈웨어 원피스', 59000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (8, 2, product_m_seq.nextval, '순면 홈웨어 상하의 세트', 88000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (9, 2, product_m_seq.nextval, 'Plant Dyeing Cotton Fabric Blind Solid', 138000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (9, 2, product_m_seq.nextval, 'Plant Dyeing Cotton Fabric Blind Line', 138000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (9, 2, product_m_seq.nextval, 'Plant Dyeing ASA Handkerchief', 20000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (9, 2, product_m_seq.nextval, 'Be The Nature Fabric Half', 198000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (9, 2, product_m_seq.nextval, 'Be The Nature Fabric Solid', 198000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (10, 2, product_m_seq.nextval, 'Garden of Paris', 32000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (10, 2, product_m_seq.nextval, 'Newyork #2', 36000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (10, 2, product_m_seq.nextval, 'Stay', 32000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (11, 2, product_m_seq.nextval, '우븐 블랭킷 - 오름(ORUM)', 259000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (11, 2, product_m_seq.nextval, '멀티 비치타월 M - 이클립스(eclipse)', 44000);
INSERT INTO product_m (brandnum, categorynum, productnum, productname, price) VALUES (11, 2, product_m_seq.nextval, '멀티 비치타월 L - 이슬라(isla)', 55000);
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