package com.smita.bootstore.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.smita.bootstore.Book;
import com.smita.bootstore.dao.BookDao;
import com.smita.bootstore.dao.IBookDao;
import com.smita.bootstore.exception.BookException;
import com.smita.bootstore.util.ConnectionUtil;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table book_master in the database.
 * 
 * @author Smita B Kumar
 *
 */
public class BookService implements IBookService{
	//prepwork
	private IBookDao bookDao =new BookDao();

	@Override
	public boolean insertBook(Book book) throws BookException {
		// TODO Auto-generated method stub
		return bookDao.insertBook(book);
	}

	@Override
	public List<Book> listAllBooks() throws BookException {
		// TODO Auto-generated method stub
		return bookDao.listAllBooks();
	}

	@Override
	public boolean deleteBook(Book book) throws BookException {
		// TODO Auto-generated method stub
		return bookDao.deleteBook(book);
	}

	@Override
	public boolean updateBook(Book book) throws BookException {
		// TODO Auto-generated method stub
		return bookDao.updateBook(book);
	}

	@Override
	public Book getBook(int id) throws BookException {
		// TODO Auto-generated method stub
		return bookDao.getBook(id);
	}
}