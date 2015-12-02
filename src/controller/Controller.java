package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Numbers;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Numbers number;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private RequestDispatcher dispatcher;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;
		
		number = new Numbers();
		try {
			number.setNumber1(Double.parseDouble(request.getParameter("number1")));
			number.setNumber2(Double.parseDouble(request.getParameter("number2")));
			number.setNumber3(Double.parseDouble(request.getParameter("number3")));			
		}catch (Exception e){
			forwardError("Mindestens eine der Zahlen war kein Double-Wert");
		}
				
		
		if(checkForDuplicates()){
			request.setAttribute("numbers", number);
			dispatcher = request.getRequestDispatcher("/Output.jsp");
			dispatcher.forward(request, response);
		}else {
			forwardError("Mindestens zwei der drei Zahlen haben den gleichen Wert.");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private boolean checkForDuplicates(){
		if(number.getNumber1() == number.getNumber2() || number.getNumber3() == number.getNumber1() || 
				number.getNumber2() == number.getNumber3()){
			return false;
		}else {
			return true;
		}
	}
	
	private void forwardError(String errorMsg) throws ServletException, IOException{
		dispatcher = request.getRequestDispatcher("/Startseite.jsp");
		request.setAttribute("Fehler", errorMsg);
		dispatcher.forward(request, response);
	}
}
