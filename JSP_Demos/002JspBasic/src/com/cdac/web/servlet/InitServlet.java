package com.cdac.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.web.model.Person;

/**
 * Servlet implementation class InitServlet
 */

@WebServlet(
		/*logical name of the servlet*/
		name="InitServlet",
		/*multiple url patters*/
        urlPatterns = { "/InitServlet","/init","/myInitServlet"},
        		/*initialization parameters of the servlet*/
        initParams = {
                @WebInitParam(name = "dev", value = "Smita"),
                @WebInitParam(name = "date", value = "18-07-2018")
        }
)
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config=getServletConfig();
		ServletContext application = request.getServletContext();
		application.setAttribute("contextName",new Person("CDAC"));
		String dev= config.getInitParameter("dev");
		String date= config.getInitParameter("date");
		HttpSession session = request.getSession();
		session.setAttribute("dev", dev);
		session.setAttribute("date", date);
		request.getRequestDispatcher("/implicit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
