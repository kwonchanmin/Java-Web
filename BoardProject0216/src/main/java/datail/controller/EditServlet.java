package datail.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.vo.BoardName;
import datail.service.DetailService;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String num = request.getParameter("num");
		String author =request.getParameter("author");
		System.out.println(Integer.parseInt(num));
		
		BoardName boardname = new BoardName();
		boardname.setBoardNum(Integer.parseInt(num));
		boardname.setBoardAuthor(author);

		DetailService service = new DetailService();
		BoardName result = service.detail(boardname);

		if (result != null) {

			HttpSession session = request.getSession(true);
			session.setAttribute("title", result);

			RequestDispatcher dispatcher = request.getRequestDispatcher("editText.jsp");
			request.setAttribute("boardtitle", result);

			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("loadingfail.html");
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
