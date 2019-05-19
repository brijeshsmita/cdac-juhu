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
 
 insert into MYUSER values(myuser_SEQ.nextval,'123','123','admin');
 insert into MYUSER values(myuser_SEQ.nextval,'111','111','user');