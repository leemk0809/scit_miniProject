DROP TABLE usr_m;
CREATE TABLE usr_m
(
    usrid VARCHAR2(50) PRIMARY KEY,
    passwd VARCHAR2(50) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    address VARCHAR2(100) NOT NULL,
    amount NUMBER NOT NULL
);

