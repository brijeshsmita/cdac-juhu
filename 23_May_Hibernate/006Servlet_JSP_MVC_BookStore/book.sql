CREATE TABLE book_master;
CREATE TABLE book_master (
  book_id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(128) NOT NULL,
  author varchar(45) NOT NULL,
  price float NOT NULL,
  PRIMARY KEY (book_id),
  UNIQUE KEY book_id_UNIQUE (book_id),
  UNIQUE KEY title_UNIQUE (title)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

insert into book_master (title,author,price) values('Java','Zara',877.99);
insert into book_master (title,author,price) values('JSP','Smita',777.99);

select * from book_master;