package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Numbers;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private RequestDispatcher dispatcher;
	private Numbers number;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request;
		this.response = response;
		
	  	HttpSession sess = request.getSession(true);
    	number = new Numbers();
	    
		try {
			number.setNumber1(Double.parseDouble(request.getParameter("Number1")));
			number.setNumber2(Double.parseDouble(request.getParameter("Number2")));
			number.setNumber3(Double.parseDouble(request.getParameter("Number3")));			
			
			sess.setAttribute("number", number);
		} catch (Exception e) {
			errorRedirect("Mindestens eine der Zahlen war kein Double-Wert");
		}

		if (checkForDuplicates()) {
			//request.setAttribute("numbers", number);
			dispatcher = request.getRequestDispatcher("/Output.jsp");
			dispatcher.forward(request, response);
		} else {
			errorRedirect("Mindestens zwei der drei Zahlen haben den gleichen Wert.");
		}
	}

	private boolean checkForDuplicates() {
		if (number.getNumber1() == number.getNumber2() || number.getNumber3() == number.getNumber1()
				|| number.getNumber2() == number.getNumber3()) {
			return false;
		} else {
			return true;
		}
	}

	private void errorRedirect(String errorMsg) throws ServletException, IOException {
		request.setAttribute("Fehler", errorMsg);
		dispatcher = request.getRequestDispatcher("/Startseite.jsp");
		dispatcher.forward(request, response);
	}
}
