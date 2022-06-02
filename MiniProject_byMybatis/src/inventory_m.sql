DROP SEQUENCE inventory_m_seq;
DROP TABLE inventory_m;
CREATE TABLE inventory_m
(
    seq NUMBER PRIMARY KEY,
    productnum REFERENCES product_m(productnum),
    stock NUMBER DEFAULT 0
);

CREATE SEQUENCE inventory_m_seq;