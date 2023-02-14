package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/sum")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 이 서블릿을 호출하려면
		// http://127.0.0.1:8080/first/sum?num1=10&num2=20

		// 1. 입력처리
		// Query String으로부터 데이터를 받으려면.. 일단 기억해야 하는건 입력받은 데이터는 무조건 문자열이다.
		String num1 = request.getParameter("num1"); // String num1에는 "10"이 들어간다.
		String num2 = request.getParameter("num2"); // num2 = "20"이 들어간다.

		// 2. 로직처리

		int sum = Integer.parseInt(num1) + Integer.parseInt(num2);

		// 3. 출력처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>" + sum + "</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 입력처리
		// http://127.0.0.1:8080/first/sum
		// Form으로부터 post방식으로 데이터를 받으려면
		// Query String으로부터 데이터를 받으려면.. 일단 기억해야 하는건 입력받은 데이터는 무조건 문자열이다.
		String num1 = request.getParameter("myNum1"); // String num1에는 "10"이 들어간다.
		String num2 = request.getParameter("myNum2"); // num2 = "20"이 들어간다.

		// 2. 로직처리

		int sum = Integer.parseInt(num1) + Integer.parseInt(num2);

		// 3. 출력처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>" + sum + "</body></html>");
		out.close();

	}

}
