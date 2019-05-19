================================================================================================
drop table employee;
drop table project;
drop table department;
create table department
(
 deptid number(2) constraint dept_pk11 primary key,
 dname varchar2(50),
 deptdesc varchar2(50)
);
drop sequence SQ_Dept11;
 create sequence SQ_Dept11
 start with 10
 increment by 10
 order;

insert into department values(SQ_Dept11.nextval,'IT','Information Techonology');
insert into department values(SQ_Dept11.nextval,'Electronics','Electronics Techonology');
insert into department values(SQ_Dept11.nextval,'HR','Human Resources');
insert into department values(SQ_Dept11.nextval,'Training','Training Techonology');
insert into department values(SQ_Dept11.nextval,'Maintainance','Accounts Dept');
insert into department values(SQ_Dept11.nextval,'Finance','Information Techonology');

select * from department;

====================================================================================
create table project
(
 projid number(6) constraint proj_pk3 primary key,
 projname varchar2(50) not null,
 projdesc varchar2(50) not null,
 deptid number(6),
 foreign key(deptid) references department(deptid)
);
drop sequence SQ_Proj3;
create sequence SQ_Proj3
start with 100
increment by 1
order;

insert into project values(SQ_proj3.nextval,'Banglore','Testing',10);
insert into project values(SQ_proj3.nextval,'Chennai','Development',20);
insert into project values(SQ_proj3.nextval,'Delhi','Training',30);
insert into project values(SQ_proj3.nextval,'Mumbai','Finance',40);
insert into project values(SQ_proj3.nextval,'Kolkata','IT',50);

select * from project;
=======================================================================================
drop table role;
create table role
(
 roleid number(6) constraint role_pk2 primary key,
 rname varchar2(25),
 rdesc varchar2(50)
 );
drop sequence SQ_Role;
create sequence SQ_Role
start with 1000
increment by 1
order;

insert into role values(SQ_Role.nextval,'Development','Developer');
insert into role values(SQ_Role.nextval,'Testing','Tester');
insert into role values(SQ_Role.nextval,'SAP','Soggeti');
insert into role values(SQ_Role.nextval,'IT','Apps1');
insert into role values(SQ_Role.nextval,'SAPBP','Apps2');

select * from role;
=======================================================================================


create table employee
(
	empid number(6) constraint employee_pk primary key,
	ename varchar2(20) not null,
	kinid varchar2(25) unique not null,
	email varchar2(50) unique not null,
	phoneno number(10) not null,
	address varchar2(50) not null,
	dob date,
	doj date,
	deptid number(6),
	projid number(6),		
	roleid number(6),
	foreign key(deptid) references department(deptid),	
	foreign key(projid) references project(projid),
	foreign key(roleid) references role(roleid)
);

drop sequence SQ_Emp;
create sequence SQ_Emp
start with 2000
increment by 1;

insert into employee values(SQ_Emp.nextval,'Ria',1234,'ria@gmail.com',9874563210,'Mumbai','19-Dec-1985','29-Dec-2015',10,101,1001);
insert into employee values(SQ_Emp.nextval,'Sia',4123,'sia@gmail.com',8745963210,'Chennai','19-Dec-1986','29-Dec-2015',20,102,1002);
insert into employee values(SQ_Emp.nextval,'Tia',2413,'tia@gmail.com',9870448461,'Delhi','19-Dec-1987','29-Dec-2015',30,103,1003);
insert into employee values(SQ_Emp.nextval,'Mia',4312,'mia@gmail.com',7066520716,'Kolkata','19-Dec-1989','29-Dec-2015',40,104,1004);


select * from employee;


select * from user;