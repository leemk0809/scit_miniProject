DROP TABLE usr_m;
CREATE TABLE usr_m
(
    usrid VARCHAR2(50) PRIMARY KEY,
    passwd VARCHAR2(50) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    address VARCHAR2(100) NOT NULL,
    amount NUMBER NOT NULL
);

-- INSERT
INSERT INTO usr_m
(usrid,  passwd, name, address, amount)
VALUES
('remona', '123', '��Ƽġ','�����', 50000);
INSERT INTO usr_m
(usrid,  passwd, name, address, amount)
VALUES
('�α���', '123', '�ια���', '�����', 200000);
INSERT INTO usr_m
(usrid,  passwd, name, address, amount)
VALUES
('mandu', '123', '����','�����', 70000);
