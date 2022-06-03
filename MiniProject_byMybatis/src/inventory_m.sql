DROP SEQUENCE inventory_m_seq;
DROP TABLE inventory_m;
CREATE TABLE inventory_m
(
    seq NUMBER PRIMARY KEY,
    productnum REFERENCES product_m(productnum),
    stock NUMBER DEFAULT 0
);

CREATE SEQUENCE inventory_m_seq;

INSERT INTO inventory_m
(seq, productnum, stock)
VALUES
(inventory_m_seq.nextval, 1, 2);

INSERT INTO inventory_m
(seq, productnum, stock)
VALUES
(inventory_m_seq.nextval, 2, 4);

commit;

select 
    seq, i.productnum, productname, price, stock
from 
    inventory_m i, product_m p
where
    i.productnum = p.productnum;

UPDATE inventory_m 
SET stock = stock + 2
WHERE productnum = 1;

commit;