drop table myuser;
create table myuser
(
	userId number(6),
	username varchar(30),
	password varchar(20),
	role varchar(30)
);

drop sequence myuser_SEQ;
create sequence myuser_SEQ
 start with 1
 increment by 1;
insert into myuser values(myuser_SEQ.NextVal,'111','111','HR');
insert into myuser values(myuser_SEQ.NextVal,'222','222','L&D');