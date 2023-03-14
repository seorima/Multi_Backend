create table member(
	id number(7) constraint member_id_pk primary key
,	email varchar(20) constraint member_emil_nn not null
,	password varchar(20) constraint member_password_nn not null
,	name varchar(20)
,	regdate date
,	constraint member_email_uq unique (email)
);

create sequence member_id_seq
	start with 1
	increment by 1
	maxvalue 9999999
	nocycle;
	

	insert into member(id, email, password, name)
	values (member_id_seq.nextval, 'longlee@daum.net', '6789','이성구')
	
	commit;
	
	select * from member;