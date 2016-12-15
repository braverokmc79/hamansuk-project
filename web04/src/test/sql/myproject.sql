

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






