

CREATE TABLE connecter_info
(
   ano       int(11),
   m_addr    varchar(30),
   m_port    varchar(10),
   m_agent   varchar(300)
)

ALTER TABLE connecter_info
   ADD PRIMARY KEY`primary`(ano)




CREATE TABLE guestbook
(
   idx         int(11),
   name        varchar(50),
   email       varchar(50),
   passwd      varchar(50),
   content     text,
   post_date   timestamp DEFAULT 'CURRENT_TIMESTAMP'
)

ALTER TABLE guestbook
   ADD PRIMARY KEY`primary`(idx)


CREATE TABLE tbl_member
(
   userid       varchar(50),
   userpw       varchar(50),
   username     varchar(50),
   email        varchar(100),
   regdate      timestamp DEFAULT 'CURRENT_TIMESTAMP',
   updatedate   timestamp DEFAULT '0000-00-00 00:00:00'
)

ALTER TABLE tbl_member
   ADD PRIMARY KEY`primary`(userid)


CREATE TRIGGER tbl_member_updatedate_insert
   BEFORE INSERT
   ON tbl_member
   FOR EACH ROW
SET new.updatedate = now()



--상품 상세

create table product(

  product_id int primary key  auto_increment, 
  product_name varchar(50),
  price int(6),
  description text,
  picture_url varchar(50),
  regdate TIMESTAMP DEFAULT now()

);



INSERT INTO hamansuk.product
(product_name, price, description, picture_url, regdate) 
VALUES ('레몬', 1500, '풍부한 레몬 ----', '/resources/template/img/page1-img1.jpg', null);

INSERT INTO hamansuk.product
(product_name, price, description, picture_url, regdate) 
VALUES ('사과', 2500, '풍부한 레몬 ----', '/resources/template/img/page1-img2.jpg', null);

INSERT INTO hamansuk.product
(product_name, price, description, picture_url, regdate) 
VALUES ('파인애풀', 3500, '풍부한 레몬 ----', '/resources/template/img/page1-img3.jpg', null);


INSERT INTO hamansuk.product
(product_name, price, description, picture_url, regdate) 
VALUES ('수박', 1000, '풍부한 레몬 ----', '/resources/template/img/page1-img4.jpg', null);


INSERT INTO hamansuk.product
(product_name, price, description, picture_url, regdate) 
VALUES ('참외', 1500, '풍부한 레몬 ----', '/resources/template/img/page1-img5.jpg', null);


INSERT INTO hamansuk.product
(product_name, price, description, picture_url, regdate) 
VALUES ('미용', 1500, '풍부한 레몬 ----', '/resources/template/img/page1-img6.jpg', null);




