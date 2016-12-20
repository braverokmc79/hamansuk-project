

CREATE TABLE connecter_info
(
   ano       int(11) AUTO_INCREMENT PRIMARY KEY ,
   m_addr    varchar(30),
   m_port    varchar(10),
   m_agent   varchar(300)
);



CREATE TABLE guestbook
(
   idx         int(11) AUTO_INCREMENT PRIMARY KEY ,
   name        varchar(50),
   email       varchar(50),
   passwd      varchar(50),
   content     text,
   post_date   timestamp DEFAULT now()
);




--상품 상세

CREATE TABLE product
(
   product_id             int(11) AUTO_INCREMENT PRIMARY KEY ,
   product_name           varchar(200),
   price                  int(6),
   description            text,
   picture_url            varchar(500),
   regdate                timestamp DEFAULT 'CURRENT_TIMESTAMP',
   original_picture_url   varchar(200)
);

INSERT INTO tbl_member(userid,
                       userpw,
                       username,
                       email,
                       regdate,
                       updatedate,
                       tel,
                       address)
     VALUES ('111', '111',
             '222',
             '222',
             '2016-12-11 17:36:45.0',
             '2016-12-11 19:39:24.0',
             NULL,
             NULL);

INSERT INTO tbl_member(userid,
                       userpw,
                       username,
                       email,
                       regdate,
                       updatedate,
                       tel,
                       address)
     VALUES ('55',
             '55',
             '555',
             '55',
             '2016-12-11 17:45:57.0',
             '2016-12-11 17:45:57.0',
             NULL,
             NULL);

INSERT INTO tbl_member(userid,
                       userpw,
                       username,
                       email,
                       regdate,
                       updatedate,
                       tel,
                       address)
     VALUES ('5553',
             '55',
             '홍길동',
             '수정 이메일',
             '2016-12-11 18:30:08.0',
             '2016-12-11 19:44:54.0',
             NULL,
             NULL);

INSERT INTO tbl_member(userid,
                       userpw,
                       username,
                       email,
                       regdate,
                       updatedate,
                       tel,
                       address)
     VALUES ('777',
             '77',
             '777',
             '777',
             '2016-12-11 18:07:18.0',
             '2016-12-11 18:07:18.0',
             NULL,
             NULL);

INSERT INTO tbl_member(userid,
                       userpw,
                       username,
                       email,
                       regdate,
                       updatedate,
                       tel,
                       address)
     VALUES ('a23',
             '23',
             '2223d',
             'e2e2',
             '2016-12-11 18:09:43.0',
             '2016-12-11 18:09:43.0',
             NULL,
             NULL);

INSERT INTO tbl_member(userid,
                       userpw,
                       username,
                       email,
                       regdate,
                       updatedate,
                       tel,
                       address)
     VALUES ('braverokmc',
             '1111',
             '최준호',
             'braverokmc@gmail.com',
             '2016-12-11 17:35:23.0',
             '2016-12-11 17:35:23.0',
             '010-222-1111',
             NULL);

INSERT INTO tbl_member(userid,
                       userpw,
                       username,
                       email,
                       regdate,
                       updatedate,
                       tel,
                       address)
     VALUES ('erwer',
             'ewr',
             'rewr',
             'erwer',
             '2016-12-11 18:08:54.0',
             '2016-12-11 18:08:54.0',
             NULL,
             NULL);

INSERT INTO tbl_member(userid,
                       userpw,
                       username,
                       email,
                       regdate,
                       updatedate,
                       tel,
                       address)
     VALUES ('ff',
             'ef',
             'gfdfd',
             'efe',
             '2016-12-11 18:19:14.0',
             '2016-12-11 18:19:14.0',
             NULL,
             NULL);

INSERT INTO tbl_member(userid,
                       userpw,
                       username,
                       email,
                       regdate,
                       updatedate,
                       tel,
                       address)
     VALUES ('sd',
             '1111',
             '이순신',
             'sds',
             '2016-12-11 18:28:43.0',
             '2016-12-11 19:50:03.0',
             NULL,
             NULL);

INSERT INTO product(product_id,
                    product_name,
                    price,
                    description,
                    picture_url,
                    regdate)
     VALUES (1,
             '레몬',
             1500,
             '풍부한 레몬 ----',
             '/resources/template/img/page3-img1.jpg',
             '2016-12-16 20:06:05.0');

INSERT INTO product(product_id,
                    product_name,
                    price,
                    description,
                    picture_url,
                    regdate)
     VALUES (2,
             '사과',
             2500,
             '풍부한 레몬 ----',
             '/resources/template/img/page3-img2.jpg',
             '2016-12-16 20:06:05.0');

INSERT INTO product(product_id,
                    product_name,
                    price,
                    description,
                    picture_url,
                    regdate)
     VALUES (3,
             '파인애풀',
             3500,
             '풍부한 레몬 ----',
             '/resources/template/img/page3-img3.jpg',
             '2016-12-16 20:06:05.0');

INSERT INTO product(product_id,
                    product_name,
                    price,
                    description,
                    picture_url,
                    regdate)
     VALUES (4,
             '수박',
             1000,
             '풍부한 레몬 ----',
             '/resources/template/img/page3-img4.jpg',
             '2016-12-16 20:06:05.0');

INSERT INTO product(product_id,
                    product_name,
                    price,
                    description,
                    picture_url,
                    regdate)
     VALUES (5,
             '참외',
             1500,
             '풍부한 레몬 ----',
             '/resources/template/img/page3-img5.jpg',
             '2016-12-16 20:06:05.0');

INSERT INTO product(product_id,
                    product_name,
                    price,
                    description,
                    picture_url,
                    regdate)
     VALUES (6,
             '미용',
             1500,
             '풍부한 레몬 ----',
             '/resources/template/img/page3-img6.jpg',
             '2016-12-16 20:06:05.0');

INSERT INTO guestbook(idx,
                      name,
                      email,
                      passwd,
                      content,
                      post_date)
     VALUES (2,
             'kim',
             'braverokmc@gmail.com',
             '1234',
             '방명록 내용',
             '2016-12-14 17:09:23.0');

INSERT INTO guestbook(idx,
                      name,
                      email,
                      passwd,
                      content,
                      post_date)
     VALUES (3,
             '홍길동',
             'kert@gmail.com',
             '1111',
             '라라라랄라',
             '2016-12-14 20:01:43.0');

INSERT INTO guestbook(idx,
                      name,
                      email,
                      passwd,
                      content,
                      post_date)
     VALUES (4,
             '줄바꿈',
             'jere@gmail.com',
             '1111',
             '줄바꿈 처리
를 합시다',
             '2016-12-14 20:05:21.0');

INSERT INTO guestbook(idx,
                      name,
                      email,
                      passwd,
                      content,
                      post_date)
     VALUES (5,
             '이순신',
             'kere@gmail.com',
             '1111',
             '줄바꿈
줄바꿈
줄바꿈'    ,
             '2016-12-15 12:00:25.0');

             
insert into tbl_member (userid, userpw, username, email, regdate, updatedate, tel, address) 
 VALUES('admin', '1111', '관리자', 'braverokmc79@gmail.com', null, null, '112', '119');
 
 
COMMIT;




--장바구니 테이블
create table cart(
 
 idx int PRIMARY KEY AUTO_INCREMENT ,
 userid VARCHAR(50) not null,
 product_id int not null,
 amount int default 1
 );


--뷰 테이블 생성
 
create or replace view cart_v as

select idx, product_name, price, amount, m.userid as userid , p.product_id as product_id, 
	picture_url,
 price*amount as money
 from cart c , tbl_member m, product p
 where c.userid=m.userid
 and c.product_id=p.product_id
 order by idx;
 

 
-- 쿼리 합계
select sum(money) money,
	case
		when sum(money) >= 50000 then 0
		when sum(money) < 50000 then 2500
	end as fee

from cart_v
where userid="admin";
 