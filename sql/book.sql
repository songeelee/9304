create table book(
book_id number primary key,
title varchar2(50) not null,
author varchar2(20) not null,
publisher varchar2(20) not null,
price number not null
);
drop table book;

drop sequence book_id;
create sequence book_id
start with 100
increment by 5
nocycle
nocache;

insert into book values (book_id.nextval, '송이의 책2','이송이','숙명',5000000);
insert into book values (book_id.nextval, '송송이의 책','이승철','메롱',100000);
commit;