package com.smita.bootstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.smita.bootstore.Book;
import com.smita.bootstore.exception.BookException;
import com.smita.bootstore.util.ConnectionUtil;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table book_master in the database.
 * 
 * @author Smita B Kumar
 *
 */
public class BookDao implements IBookDao{
	//prepwork -1
	private Connection jdbcConnection;

	@Override  public boolean insertBook(Book book) throws BookException {
		String sql = "INSERT INTO book_master (title, author, price) VALUES (?, ?, ?)";
		//prepwork -2
		jdbcConnection = ConnectionUtil.connect();
		boolean rowInserted = false;
		try (PreparedStatement statement = jdbcConnection.prepareStatement(sql);) {

			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setFloat(3, book.getPrice());

			rowInserted = statement.executeUpdate() > 0;
			//prepwork -3
			ConnectionUtil.disconnect();
		} catch (SQLException e) {
			throw new BookException(e.getMessage());
		}

		return rowInserted;
	}

	@Override  public List<Book> listAllBooks() throws BookException {
		List<Book> listBook = new ArrayList<>();
		String sql = "SELECT * FROM book_master";
		jdbcConnection = ConnectionUtil.connect();
		try (Statement statement = jdbcConnection.createStatement();) {
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("book_id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				float price = resultSet.getFloat("price");

				Book book = new Book(id, title, author, price);
				listBook.add(book);
			}
			ConnectionUtil.disconnect();
		} catch (SQLException e) {
			throw new BookException(e.getMessage());
		}
		return listBook;
	}

	@Override  public boolean deleteBook(Book book) throws BookException {
		String sql = "DELETE FROM book_master where book_id = ?";
		jdbcConnection = ConnectionUtil.connect();
		boolean rowDeleted = false;
		try (PreparedStatement statement = jdbcConnection.prepareStatement(sql);) {
			statement.setInt(1, book.getId());
			rowDeleted = statement.executeUpdate() > 0;
			ConnectionUtil.disconnect();
		} catch (SQLException e) {
			throw new BookException(e.getMessage());
		}
		return rowDeleted;
	}

	@Override  public boolean updateBook(Book book) throws BookException {
		String sql = "UPDATE book_master SET title = ?, author = ?, price = ?";
		sql += " WHERE book_id = ?";
		jdbcConnection = ConnectionUtil.connect();
		boolean rowUpdated = false;
		try (PreparedStatement statement = jdbcConnection.prepareStatement(sql);) {
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setFloat(3, book.getPrice());
			statement.setInt(4, book.getId());

			rowUpdated = statement.executeUpdate() > 0;
			statement.close();
			ConnectionUtil.disconnect();
		} catch (SQLException e) {
			throw new BookException(e.getMessage());
		}
		return rowUpdated;
	}

	@Override  public Book getBook(int id) throws BookException {
		Book book = null;
		String sql = "SELECT * FROM book_master WHERE book_id = ?";
		jdbcConnection = ConnectionUtil.connect();
		try (PreparedStatement statement = jdbcConnection.prepareStatement(sql);) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				float price = resultSet.getFloat("price");

				book = new Book(id, title, author, price);
			}
			ConnectionUtil.disconnect();
		} catch (SQLException e) {
			throw new BookException(e.getMessage());
		}
		return book;
	}
}
