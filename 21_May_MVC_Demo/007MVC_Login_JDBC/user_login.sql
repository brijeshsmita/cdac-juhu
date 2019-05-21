drop table mvc_user;
create table mvc_user
(
	user_id int NOT NULL AUTO_INCREMENT,
	username varchar(30),
	password varchar(20),
	role varchar(30),
	PRIMARY KEY (user_id),
	UNIQUE KEY user_id_UNIQUE (user_id),
  UNIQUE KEY username_UNIQUE (username)
)ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

insert into mvc_user (username,password,role) values('111','111','admin');
insert into mvc_user (username,password,role) values('admin','admin','admin');