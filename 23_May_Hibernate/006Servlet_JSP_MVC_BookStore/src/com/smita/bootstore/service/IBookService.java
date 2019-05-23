/**
 * 
 */
package com.smita.bootstore.service;

import java.util.List;

import com.smita.bootstore.Book;
import com.smita.bootstore.exception.BookException;

/**
 * @author Smita B Kumar
 *
 */
public interface IBookService {

	boolean insertBook(Book book) throws BookException;

	List<Book> listAllBooks() throws BookException;

	boolean deleteBook(Book book) throws BookException;

	boolean updateBook(Book book) throws BookException;

	Book getBook(int id) throws BookException;

}
