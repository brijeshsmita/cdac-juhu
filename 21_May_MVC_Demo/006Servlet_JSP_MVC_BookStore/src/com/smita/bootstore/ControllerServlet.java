package com.smita.bootstore;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smita.bootstore.exception.BookException;
import com.smita.bootstore.service.BookService;
import com.smita.bootstore.service.IBookService;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the user.
 * 
 * @author Smita B Kumar
 */
@WebServlet("/")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookService bookService=new BookService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//getting the servletPath
	String action = request.getServletPath();
		RequestDispatcher dispatcher = null;
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertBook(request, response);
				break;
			case "/delete":
				deleteBook(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateBook(request, response);
				break;
			default:
				listBook(request, response);
				break;
			}
		} catch (BookException | IOException | ServletException e) {
			/*dispatcher = request.getRequestDispatcher("Error.jsp");*/ e.printStackTrace();
			//dispatcher.forward(request, response);
		}
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> listBook = null;
		RequestDispatcher dispatcher = null;
		try {
			listBook = bookService.listAllBooks();
			request.setAttribute("listBook", listBook);
			dispatcher = request.getRequestDispatcher("BookList.jsp");
			dispatcher.forward(request, response);
		} catch (BookException | IOException | ServletException e) {
			/*dispatcher = request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);*/
			e.printStackTrace();
		}

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		try {
			dispatcher = request.getRequestDispatcher("BookForm.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			/*dispatcher = request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);*/
			e.printStackTrace();
		}

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws BookException, ServletException, IOException {
		//fetching the id from request parameter
		int id = Integer.parseInt(request.getParameter("id"));
		Book existingBook = null;
		RequestDispatcher dispatcher = null;
		try {
			//calling the service to get the book for that id
			existingBook = bookService.getBook(id);
			dispatcher = request.getRequestDispatcher("BookForm.jsp");
			//putting the bookk object in request scope
			request.setAttribute("book", existingBook);
			//forwarding it to BookForm.jsp
			dispatcher.forward(request, response);
		} catch (BookException | IOException | ServletException e) {
			/*dispatcher = request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);*/
			e.printStackTrace();
		}

	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		//fetching the request parameter
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));
		
		//creating the book object
		Book newBook = new Book(title, author, price);
		RequestDispatcher dispatcher = null;
		try {
			//calling the service to insert the book
			bookService.insertBook(newBook);
			response.sendRedirect("list");
		} catch (BookException | IOException e) {
			/*dispatcher = request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);*/
			e.printStackTrace();
		}
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));
		//fetching all the request parameter
		RequestDispatcher dispatcher = null;
		boolean status =false;
		try {
			//creating object of book
			Book book = new Book(id, title, author, price);
			//calling the service to update the book
			status=bookService.updateBook(book);
			if(status)
				response.sendRedirect("list");
			else {
				dispatcher = request.getRequestDispatcher("Error.jsp");
				dispatcher.forward(request, response);
			}
		} catch (BookException | IOException e) {
			/*dispatcher = request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);*/
			e.printStackTrace();
		}
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response)
			throws BookException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		RequestDispatcher dispatcher = null;
		boolean status =false;
		try {
			Book book = new Book(id);
			status=bookService.deleteBook(book);
			if(status)
				response.sendRedirect("list");
			else {
				dispatcher = request.getRequestDispatcher("Error.jsp");
				dispatcher.forward(request, response);
			}
		} catch (BookException | IOException e) {
			/*dispatcher = request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);*/
			e.printStackTrace();
		}
	}

}
