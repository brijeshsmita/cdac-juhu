/**
 * 
 */
package com.smita.bootstore.dao;

import java.util.List;

import com.smita.bootstore.Book;
import com.smita.bootstore.exception.BookException;

/**
 * @author Smita B Kumar
 *
 */
public interface IBookDao {

	boolean insertBook(Book book) throws BookException;//C -create-insert
	List<Book> listAllBooks() throws BookException;//R-retrieve-select
	boolean updateBook(Book book) throws BookException;//U- update
	boolean deleteBook(Book book) throws BookException;//D-Delete
	Book getBook(int id) throws BookException;//S- search-select

}
